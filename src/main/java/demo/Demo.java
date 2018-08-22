package demo;

public class Demo {
    public static void main(String[] args) {
        IntHolder factualParam = new IntHolder(0);
        nestedMethod(factualParam);
        System.out.println(factualParam.getState());
    }

    /**
     * For primitives: Pass By Value.
     * For references: Pass By Reference.
     */
    private static void nestedMethod(IntHolder formalParam) {
        formalParam.setState(1);
    }
}

//POJO
class IntHolder {
    private int state;

    public IntHolder(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}