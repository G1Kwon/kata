package ALU;

public class Alu_1 {

    private int operand1 = -1;
    private int operand2 = -1;
    private String OPCODE = "";

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public void setOPCODE(String OPCODE) {
        this.OPCODE = OPCODE;
    }

    public void enableSignal(Result r) {

        if (!OPCODE.equals("ADD") == true && !OPCODE.equals("MUL") == true && !OPCODE.equals("SUB") == true) {
            r.setResult(65535);
            r.setStatus(3);
            return;
        }
        if (operand1 == -1) {
            r.setResult(65535);
            r.setStatus(1);
            return;
        }
        if (operand2 == -1) {
            r.setResult(65535);
            r.setStatus(2);
            return;
        }

        int result = 65535;
        if (OPCODE.equals("ADD")) {
            result = operand1 + operand2;
        } else if (OPCODE.equals("MUL")) {
            result = operand1 * operand2;
        } else if (OPCODE.equals("SUB")) {
            result = operand1 - operand2;
        }

        r.setResult(result);
        r.setStatus(0);
    }
}