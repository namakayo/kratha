package kratha;

import arc.*;
import arc.util.*;
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
            loadSettings();
        });
    }
    public void loadSettings(){
        ui.settings.addCategory(Core.bundle.get("settings.kratha-title"), Icon.book, t -> {
            t.checkPref("@settings.terraplasm-item-debug", false);
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
