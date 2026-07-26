package kratha.world.blocks.defense;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.io.*;
import mindustry.*;
import mindustry.world.blocks.defense.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.content.Blocks;

import static mindustry.Vars.*;

public class InitialRadar extends Radar{
    public InitialRadar(String name){
        super(name);
    }
    public class RadarBuild extends Building{
        @Override
        public void updateTile(){
            super.updateTile();
            if(progress>=0.99f){
                tile.setBlock(Blocks.air);
            }
        }
    }
}