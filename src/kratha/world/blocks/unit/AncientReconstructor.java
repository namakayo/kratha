package kratha.world.blocks.units;

import mindustry.gen.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.units.*;

import static mindustry.Vars.state;

public class AncientReconstructor extends Reconstructor{
    public AncientReconstructor(String name){
        super(name);
        allowDerelictRepair = false;
    }

    @Override
    public void setBars(){
        //no
    }

    @Override
    public boolean canBreak(Tile tile){
        return state.rules.editor;
    }

    public class AncientReconstructorBuild extends ReconstructorBuild{
        
        @Override
        public void damage(float damage){
            return; //no damage
        }

        @Override
        public boolean canPickup(){
            return false; //no
        }

        @Override
        public boolean collide(Bullet other){
            return false; //no
        }
    }
}
