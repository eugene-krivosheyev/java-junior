package demo;

public class ParametersPassingStyles {
    public static void main(String[] args) {
        int factualParam = 5;
        m(factualParam); //Factual param
        System.out.println(factualParam);
    }

    private static void m(int formalParam) { //Formal parameter
        formalParam = 1;
    }
}


