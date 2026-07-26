package kratha.world.blocks.environment;

import mindustry.world.blocks.environment.Floor;
import arc.*;
import arc.audio.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.graphics.MultiPacker.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;

import java.util.*;

import static mindustry.Vars.*;

//for edge support for when liquid floor is next to normal floor
public class ArkteraFloor extends Floor{
    public ArkteraFloor(String name){
        super(name);
    }
    public ArkteraFloor(String name, int variants){
        super(name);
        variants = variants;
    }
    @Override
    protected void drawEdges(Tile tile){
        blenders.clear();
        blended.clear();
        Arrays.fill(dirs, 0);
        
        for(int i = 0; i < 8; i++){
            Point2 point = Geometry.d8[i];
            Tile other = tile.nearby(point);
  
            if(other == null) continue;
  
            Floor ob = (this == tile.floor() || other.overlay() == Blocks.air ? other.floor() : other.overlay());
            
            if(ob.drawEdgeOut && doEdge(tile, other, ob)){
                if(!blended.getAndSet(ob.id)){
                    blenders.add(ob);
                }
                dirs[i] = ob.id;
            }
        }
  
        drawBlended(tile, true);
    }
}