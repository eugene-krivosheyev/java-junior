package demo;

public class ParametersPassingStyles {
    public static int globalState;

    public static void main(String[] args) {
        Data factualParam = new Data();
        factualParam.setState(1);

        m(factualParam); //if Factual param instanceof Object -> side effect
        System.out.println(factualParam.getState());
    }

    //===================

    private int objectState;
    private static void m(Data formalParam) { //Formal parameter
        formalParam.setState(5);
    }
}

class Data {
    private int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

