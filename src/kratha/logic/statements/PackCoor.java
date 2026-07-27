package kratha.logic.statements;

import arc.scene.ui.layout.Table;
import mindustry.logic.*;
import kratha.logic.*;

public static class PackCoor extends LStatement{
    public String result = "result", x = "0", y = "0";

    @Override
    public void build(Table table){
        fields(table, result, str -> result = str);

        table.add(" = pack ");

        row(table);

        fields(table, x, str -> x = str);
        fields(table, y, str -> y = str);
    }

    @Override
    public LInstruction build(LAssembler builder){
        return new PackCoorI(builder.var(result), builder.var(x), builder.var(y));
    }

    @Override
    public LCategory category(){
        return KrathaLogic.krathaCategory;
    }
}