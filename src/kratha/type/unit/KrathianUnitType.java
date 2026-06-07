package kratha.type.unit;

import arc.math.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import kratha.content.KrathaItems;
import kratha.*;
import kratha.content.*;
import mindustry.entities.abilities.*;
import kratha.content.blocks.*;
import kratha.world.blocks.environment.*;

public class KrathianUnitType extends UnitType{

    public KrathianUnitType(String name){
        super(name);
        outlineColor = KrathaPal.krathianOutline;
        envDisabled = Env.none;
        drawCell = false;
        useUnitCap = false;
        lightRadius = 0;
        engineSize = 0;

        abilities.add(new RegenAbility(){{
            percentAmount = 1f / (80f * 60f) * 100f;
        }});

        abilities.add(new LiquidExplodeAbility(){{
            liquid = KrathaLiquids.krathagen;
        }});

        healFlash = false;
    }
}
