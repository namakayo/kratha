package kratha.world.blocks.storage;

import mindustry.world.blocks.storage.CoreBlock;
import static mindustry.Vars.*;

public class KrathaCoreBlock extends CoreBlock {
    public KrathaCoreBlock(String name){
        super(name);
    }
    
    public class KrathaCoreBuild extends CoreBuild {
        @Override
        public void updateTile(){
            super.updateTile();
            state.rules.worldProcessorPlayerLink = true; //im genius
        }
    }
 }     
