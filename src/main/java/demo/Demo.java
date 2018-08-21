package demo;

public class Demo {
    public static void main(String[] args) {
        int factualParam = 0;
        nestedMethod(factualParam);
        System.out.println(factualParam);
    }

    /**
     * For primitives: Pass By Value
     */
    private static void nestedMethod(int formalParam) {
        formalParam = 1;
    }
}
