package kratha.content.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import kratha.content.KrathaItems;
import kratha.content.*;
import mindustry.content.*;
import kratha.world.blocks.units.*;
import kratha.world.blocks.payloads.*;

import static mindustry.type.ItemStack.with;

public class KrathaUnits {
    public static Block
            nauticAssembler, ancientFactory, rocketInstaller, ancientPayloadLauncher;
    public static void load() {
        {
            {
                nauticAssembler = new UnitFactory("nautic-assembler"){{
                    requirements(Category.units, with(KrathaItems.krathite,75,KrathaItems.guartz,60,KrathaItems.spurstone,30,KrathaItems.cobalt,30));
                    plans.add(new UnitPlan(KrathaUnitTypes.sail, 15 * 60f, with(KrathaItems.krathite, 15,KrathaItems.cobalt, 10)));
                    consumePower(60/60f);
                    size = 3;
                    configurable = false;
                    researchCost = with(KrathaItems.krathite,200,KrathaItems.guartz,180,KrathaItems.spurstone,100,KrathaItems.cobalt,50);
                }};
                ancientFactory = new AncientUnitFactory("ancient-factory"){{
                    requirements(Category.units, BuildVisibility.sandboxOnly, with());
                    plans.add(new UnitPlan(KrathaUnitTypes.keris, 14 * 60f, with(KrathaItems.guartz, 15,KrathaItems.spurstone, 10)));
                    size = 4;
                    canPickup = false;
                    configurable = false;
                    hasLiquids = true;
                    consumeLiquid(KrathaLiquids.terac, 3f / 60f);
                }};
                rocketInstaller = new AncientReconstructor("rocket-installer"){{
                    requirements(Category.units, BuildVisibility.sandboxOnly, with());
                    size = 4;
                    consumeItems(with(KrathaItems.akrscarp, 12, KrathaItems.cobalt, 9));
                    consumeLiquid(KrathaLiquids.terac, 9f / 60f);
                    constructTime = 60f * 10f;
                    upgrades.add(new UnitType[]{KrathaUnitTypes.sail, KrathaUnitTypes.sailRocket});
                }};
                ancientPayloadLauncher = new AncientPayloadMassDriver("ancient-payload-launcher"){{
                    requirements(Category.units, BuildVisibility.sandboxOnly, with(KrathaItems.krathite, 150, KrathaItems.spurstone, 200, KrathaItems.cobalt, 90));
                    size = 4;
                    reload = 150f;
                    chargeTime = 120f;
                    range = 400f;
                    solid = false;
                    maxPayloadSize = 4f;
                    fogRadius = 0;
        }};
            }
        }
    }
}
