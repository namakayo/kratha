package kratha;

import arc.*;
import arc.util.*;
import arc.scene.style.TextureRegionDrawable;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import kratha.content.blocks.KrathaBlocks;
import kratha.content.*;
import mindustry.gen.*;
import kratha.ui.TeamsUI;

import static mindustry.Vars.*;

public class KrathaMod extends Mod{

    public KrathaMod(){
        Log.info("They are watching."); //no reason for this lol
        Events.on(ClientLoadEvent.class,e->{
            ui.settings.addCategory(Core.bundle.get("kratha.kratha-title"),new TextureRegionDrawable(Core.atlas.find("kratha-setting-icon")),t -> {
                t.checkPref("kratha.terraplasm-item-debug", false);
            });
        });
    }
    @Override
    public void init(){
        super.init();
        TeamsUI.init();
        KrathaVars.init();
    }
    @Override
    public void loadContent(){
        KrathaTeams.load();
        KrathaItems.load();
        KrathaLiquids.load();
        KrathaWeathers.load();
        KrathaStatusEffects.load();
        KrathaUnitTypes.load();
        KrathaBlocks.load();
        KrathaPlanets.load();
        KrathaSectorPresets.load();
        KrathaTechTree.load();
    }

}
