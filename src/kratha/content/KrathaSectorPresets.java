package kratha.content;

import kratha.content.KrathaPlanets;
import kratha.type.KrathaSectorPreset;
import mindustry.type.SectorPreset;

public class KrathaSectorPresets {
    public static KrathaSectorPreset theFountain,seaport,comingSoon;

    public static void load(){
        theFountain = new KrathaSectorPreset("the-fountain", KrathaPlanets.kratha, 452){{
           alwaysUnlocked = true;
           difficulty = 1;
           overrideLaunchDefaults = true;
        }};
        seaport = new KrathaSectorPreset("seaport", KrathaPlanets.kratha, 32){{
           difficulty = 3;
           overrideLaunchDefaults = true;
        }};
        comingSoon = new KrathaSectorPreset("coming-soon", KrathaPlanets.kratha, 32){{
           difficulty = 0;
           overrideLaunchDefaults = true;
        }};
    }
}
