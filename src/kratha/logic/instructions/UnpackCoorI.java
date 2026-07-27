package kratha.logic.instructions;

import mindustry.logic.*;

public class UnpackCoorI implements LExecutor.LInstruction {
    public LVar source, x, y;
    
    public UnpackCoorI(LVar source, LVar x,LVar y){
        this.source = source;
        this.x = x;
        this.y = y;
    }
    
    public UnpackCoorI();
    
    @Override
    public void run(LExecutor exec){
        long packed = Double.doubleToLongBits(source.numf());
        int bits1 = (int) (packed >> 32);
        int bits2 = (int) packed;
        x.setnum(Float.intBitsToFloat(bits1));
        y.setNum(Float.intBitsToFloat(bits2));
    }
}