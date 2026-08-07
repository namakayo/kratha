package kratha.util;

import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import mindustry.world.*;
import mindustry.gen.*;
import kratha.world.blocks.terraplasm.*;

import static mindustry.Vars.*;

//Greedy best first search for items in roots
public class RootPathfinder{
  public Seq findPath(int fromx, int fromy, int tox, int toy){
    int limit=0;
    int maxLimit=100000;
    boolean notFound=false;
    Tile targetTile=world.tile(tox,toy):
    if(targetTile==null||targetTile.build==null){
      return new Seq();
    }
    Building target=targetTile.build;
    Seq queue=new Seq();
    Seq done=new Seq();
    done.add(new Node(fromx,fromy,fromx,fromy,Mathf.dst(fromx,fromy,tox,toy)));
    while(true){
      for(int i=0;i<done.size;i++){
        if(done.get(i) instanceof Node n&&!n.checked){
          for(int j=0;j<4;j++){
            int ax=n.x+Geometry.d4[j].x;
            int ay=n.y+Geometry.d4[j].y;
            Tile a=world.tile(ax,ay);
            if(a!=null&&a.build!=null&&a.build.block instanceof Root){
              if(!hasPos(done,ax,ay)){
                queue.add(new Node(ax,ay,n.x,n.y,Mathf.dst(ax,ay,tox,toy)));
              }
            }else if(a!=null&&a.build!=null&&a.build==target){
              queue.add(new Node(tox,toy,n.x,n.y,0));
            }
          }
          n.checked=true;
        }
      }
      if(queue.size<=0||limit>maxLimit){
        notFound=true;
        break;
      }
      float closest=Float.POSITIVE_INFINITY;
      int closesti=0;
      for(int i=0;i<queue.size;i++){
        if(queue.get(i) instanceof Node n){
          if(n.val<closest){
            closest=n.val;
            closesti=i;
          }
        }
      }
      if(queue.get(closesti) instanceof Node priority){
        queue.remove(closesti);
        done.add(priority);
        if(priority.val==0){
          break;
        }
      };
      limit++;
    }
    if(notFound){
      return new Seq();
    }
    Seq trace=new Seq();
    limit=0;
    Node lastTrace=(Node)done.get(done.size-1);
    trace.add(new Point2(lastTrace.x,lastTrace.y));
    while(limit<maxLimit){
      int lp=findPos(done,lastTrace.px,lastTrace.py);
      if(lp!=-1&&done.get(lp) instanceof Node n){
        if(n.isSource()){
          break;
        }
        trace.add(new Point2(n.x,n.y));
        lastTrace=n;
      }
      limit++;
    }
    return trace;
  }
  protected boolean hasPos(Seq seq,int x,int y){
    for(int i=0;i<seq.size;i++){
      if(seq.get(i) instanceof Node n){
        if(n.x==x&&n.y==y){
          return true;
        }
      }
    }
    return false;
  }
  protected boolean hasPos2(Seq seq,int x,int y){
    for(int i=0;i<seq.size;i++){
      if(seq.get(i) instanceof Point2 n){
        if(n.x==x&&n.y==y){
          return true;
        }
      }
    }
    return false;
  }
  protected int findPos(Seq seq,int x,int y){
    for(int i=0;i<seq.size;i++){
      if(seq.get(i) instanceof Node n){
        if(n.x==x&&n.y==y){
          return i;
        }
      }
    }
    return -1;
  }

  protected class Node{
    public int x;
    public int y;
    public int px;
    public int py;
    public float val;
    public boolean checked=false;
    public Node(int x,int y,int px,int py,float val){
      this.x=x;
      this.y=y;
      this.px=px;
      this.py=py;
      this.val=val;
    }
    public boolean isSource(){
      return x==px&&y==py;
    }
  }
}