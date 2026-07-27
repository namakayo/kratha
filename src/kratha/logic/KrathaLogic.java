package kratha.logic;

import arc.graphics.Color;
import kratha.graphics.*;
import mindustry.gen.*;
import mindustry.logic.*;
import kratha.logic.statements.*;

public class KrathaLogic{
    public static LCategory krathaCategory;

    public static void init(){
        krathaCategory = new LCategory("kratha-category", KrathaPal.krathaLogicCol);

        LAssembler.customParsers.put("packcoor", PackCoor::new);
        LAssembler.customParsers.put("unpackcoor", UnpackCoor::new);
        
        LogicIO.allStatements.addUnique(PackCoor::new);
        LogicIO.allStatements.addUnique(UnpackCoor::new);
    }
}