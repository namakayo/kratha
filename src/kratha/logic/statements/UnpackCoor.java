package kratha.logic.statements;

import arc.scene.ui.layout.Table;
import mindustry.logic.*;
import kratha.logic.*;

public static class UnpackCoor extends LStatement{
    public String result = "source", x = "0", y = "0";

    @Override
    public void build(Table table){
        fields(table, source, str -> source = str);

        table.add(" = unpack ");

        row(table);

        fields(table, x, str -> x = str);
        fields(table, y, str -> y = str);
    }

    @Override
    public LInstruction build(LAssembler builder){
        return new UnpackCoorI(builder.var(source), builder.var(x), builder.var(y));
    }

    @Override
    public LCategory category(){
        return KrathaLogic.krathaCategory;
    }
}