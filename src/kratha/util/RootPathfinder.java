package kratha.util;

import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import mindustry.world.*;
import kratha.world.blocks.terraplasm.*;

import static mindustry.Vars.*;

public class RootPathfinder{
  public Seq findPath(int fromx, int fromy, int tox, int toy){
    int limit=0;
    Seq queue=new Seq();
    Seq done=new Seq();
    done.add(new Node(fromx,fromy,fromx,fromy,Mathf.dst(fromx,fromy,tox,toy)));
    while(limit<100){
      for(int i=0;i<done.size;i++){
        if(done.get(i) instanceof Node n){
          for(int j=0;j<4;j++){
            int ax=n.x+Geometry.d4[j].x;
            int ay=n.y+Geometry.d4[j].y;
            Tile a=world.tile(ax,ay);
            if(a!=null&&a.build!=null&&a.build.block instanceof Root){
              if(!hasPos(done,ax,ay)){
                queue.add(new Node(ax,ay,n.x,n.y,Mathf.dst(ax,ay,tox,toy)));
              }
            }
          }
        }
      }
      if(queue.size<=0){
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
      };
      limit++;
    }
    Seq output=new Seq();
    for(int i=0;i<done.size;i++){
      if(done.get(i) instanceof Node n){
        output.add(new Point2(n.x,n.y));
      }
    }
    return output;
  }
  protected boolean hasPos(Seq seq,int x,int y){
    for(let i=0;i<seq.size;i++){
      if(seq.get(i) instanceof Node n){
        if(n.x==x&&n.y==y){
          return true;
        }
      }
    }
    return false;
  }
  protected class Node{
    public int x;
    public int y;
    public int px;
    public int py;
    public float val;
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