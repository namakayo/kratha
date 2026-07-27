package kratha.logic.instructions;

import mindustry.logic.*;

public class PackCoorI implements LExecutor.LInstruction {
    public LVar result, x, y;
    
    public PackCoorI(LVar result, LVar x,LVar y){
        this.result = result;
        this.x = x;
        this.y = y;
    }
    
    public PackCoorI()
    
    @Override
    public void run(LExecutor exec){
        int bits1 = Float.floatToIntBits(x.numf());
        int bits2 = Float.floatToIntBits(y.numf());
        long packed = (((long) bits1) << 32) | (bits2 & 0xffffffffL);
        result.setnum(Double.longBitsToDouble(packed));
    }
}