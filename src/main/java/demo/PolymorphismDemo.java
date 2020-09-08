package demo;

public class PolymorphismDemo {
    public static void main(String[] args) {
        doSmthWithParam("abc");
        doSmthWithParam(4);
    }

    private static void doSmthWithParam(Object param) {
        System.out.println(param);
    }
}
