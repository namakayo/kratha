package kratha.util;

import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import mindustry.world.*;
import kratha.world.blocks.terraplasm.*;

import static mindustry.Vars.*;

public class RootPathfinder{
  public static Seq findPath(int fromx, int fromy, int tox, int toy){
    Seq queue=new Seq();
    Seq done=new Seq();
    done.add(new Node(fromx,fromy,fromx,fromy,Mathf.dst(fromx,fromy,tox,toy)));
    while(true){
      for(int i=0;i<done.size;i++){
        Node n=done.get(i);
        for(int j=0;j<4;j++){
          int ax=n.x+Geometry.d4[j].x;
          int ay=n.y+Geometry.d4[j].y;
          Tile a=world.tile(ax,ay);
          if(a!=null&&a.build!=null&&a.build.block instanceof Root){
            queue.add(new Node(ax,ay,n.x,n.y,Mathf.dst(ax,ay,tox,toy)));
          }
        }
      }
      if(queue.size<=0){
        break;
      }
      float closest=Float.POSITIVE_INFINITY;
      int closesti=0;
      for(int i=0;i<queue.size;i++){
        Node n=queue.get(i);
        if(n.val<closest){
          closest=n.val;
          closesti=i;
        }
      }
      Node priority=queue.get(closesti);
      queue.remove(closesti);
      done.add(priority);
    }
    return done;
  }
  protected class Node{
    public int x;
    public int y;
    public int px;
    public int py;
    public float val;
    public Node(int x,int y,int px,int py,float val){
      x=x;
      y=y;
      px=px;
      py=py;
      val=val;
    }
    public boolean isSource(){
      return x==px&&y==py;
    }
  }
}