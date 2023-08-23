import ALU.Alu;
import ALU.Result;
import org.junit.Test;

import static org.junit.Assert.*;

class AluTest {

    @Test
    public void getCal() {
        Alu alu = new Alu();
        alu.setOperand1(10);
        alu.setOperand2(20);
        alu.setOPCODE("ADD");

        Result ret = new Result();
        alu.enableSignal(ret);

        assertEquals(30, ret.getResult());
        assertEquals(0, ret.getStatus());
    }

}