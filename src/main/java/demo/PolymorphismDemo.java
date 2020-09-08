package demo;

public class PolymorphismDemo {
    public static void main(String[] args) {
        doSmthWithParam("abc"); // IS-A: extends | implements
        doSmthWithParam(new Double("4.0"));
    }

    private static void doSmthWithParam(Object param) {
//        param.toUpperCase();
        System.out.println(param);
    }
}
