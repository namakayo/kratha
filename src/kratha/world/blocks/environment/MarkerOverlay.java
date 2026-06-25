package kratha.world.blocks.environment;

import arc.Core;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.game.*;
import mindustry.world.*;
import mindustry.graphics.*;
import mindustry.world.blocks.environment.OverlayFloor;

import static mindustry.Vars.*;

public class MarkerOverlay extends OverlayFloor{
    public MarkerOverlay(String name){
        super(name);
        variants = 0;
    }
    @Override
    public void drawBase(Tile tile){
        if(state.isEditor()||state.isMenu())Draw.rect(region, tile.worldx(), tile.worldy());
    }
}
