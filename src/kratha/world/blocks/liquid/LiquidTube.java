package kratha.world.blocks.liquid;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.math.geom.*;
import mindustry.world.blocks.liquid.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;
import mindustry.entities.units.BuildPlan;

import static mindustry.Vars.*;

public class LiquidTube extends Conduit {
    //why shadedTopRegions and not topRegions?~
    public TextureRegion[][] shadedTopRegions = new TextureRegion[4][4];
    public LiquidTube(String name){
        super(name);
    }
    @Override
    public void load(){
        super.load();
        
        int y = 0;
        for(int cy = 0; cy < 4; cy++, y+=32){
            int x = 0;
            for(int cx = 0; cx < 4; cx++, x+=32){
                shadedTopRegions[cy][cx]=new TextureRegion(Core.atlas.find(name+"-top-atlas"), x, y, 32, 32);
            }
        }
    }
    @Override
    public boolean blends(Tile tile, int rotation, int otherx, int othery, int otherrot, Block otherblock){
        return (otherblock.outputsItems() || (lookingAt(tile, rotation, otherx, othery, otherblock) && otherblock.hasItems))
        && lookingAtEither(tile, rotation, otherx, othery, otherrot, otherblock);
    }
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{Core.atlas.find(name+"-preview")};
    }
    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        int[] bits = getTiling(plan, list);

        if(bits == null) return;

        TextureRegion region = Core.atlas.find(name+"-preview");
        Draw.rect(region, plan.drawx(), plan.drawy(), region.width * bits[1] * region.scl(), region.height * bits[2] * region.scl(), plan.rotation * 90);
    }
    public class LiquidTubeBuild extends ConduitBuild {
        @Override
        public void draw(){
            int r = this.rotation;

            if(under) Draw.color(botColor);

            //draw extra conduits facing this one for tiling purposes
            Draw.z(Layer.blockUnder);
            for(int i = 0; i < 4; i++){
                if((blending & (1 << i)) != 0){
                    int dir = r - i;
                    drawAt(x + Geometry.d4x(dir) * tilesize*0.75f, y + Geometry.d4y(dir) * tilesize*0.75f, 0, i == 0 ? r : dir, i != 0 ? SliceMode.bottom : SliceMode.top, under);
                }
            }

            Draw.z(Layer.block);

            Draw.scl(xscl, yscl);
            drawAt(x, y, blendbits, r, SliceMode.none, under);
            Draw.reset();

            if(!under) return;

            if(capped && capRegion.found()) Draw.rect(capRegion, x, y, rotdeg());
            if(backCapped && capRegion.found()) Draw.rect(capRegion, x, y, rotdeg() + 180)
                }
    }
}
