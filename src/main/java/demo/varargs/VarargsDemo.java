package demo.varargs;

public class VarargsDemo {
    public static void main(String[] args) {
        m2(1);
        m3("", "");
    }

    private static void m3(String... args) {
        for (String c : args) {
            System.out.println(c);
        }
    }

    private static void m2(int a) {
    }

    private static void m2(int... param) {
        System.out.println(param[0]);
        for (int current : param) {

        }
    }


}
