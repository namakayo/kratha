package kratha.world.blocks.terraplasm;

//Top 17 most reasonable import
import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import arc.math.geom.*;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;
import mindustry.graphics.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.type.*;

import static mindustry.Vars.*;

public class BioWall extends BioBlock {
    public BioWall(String name){
        super(name);
        isRoot=false;
        solid=true; 
    }
    public class BioWallBuild extends BioBuilding {
        //its just a wall, nothing here
    }
 }     
