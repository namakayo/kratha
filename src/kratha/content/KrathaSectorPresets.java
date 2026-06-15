package kratha.content;

import kratha.content.KrathaPlanets;
import kratha.type.KrathaSectorPreset;
import mindustry.type.SectorPreset;

public class KrathaSectorPresets {
    public static KrathaSectorPreset theFountain,oasis,harbor;

    public static void load(){
        theFountain = new KrathaSectorPreset("the-fountain", KrathaPlanets.kratha, 452){{
           alwaysUnlocked = true;
           difficulty = 1;
           overrideLaunchDefaults = true;
        }};
        oasis = new KrathaSectorPreset("oasis", KrathaPlanets.kratha, 32){{
           difficulty = 1;
           overrideLaunchDefaults = true;
        }};
        harbor = new KrathaSectorPreset("harbor", KrathaPlanets.kratha, 456){{
           difficulty = 2;
           overrideLaunchDefaults = true;
        }};
    }
}
