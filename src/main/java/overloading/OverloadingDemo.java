package overloading;

public class OverloadingDemo {
    public static void main(String[] args) {
        m(1);
        System.out.println(1 + "2" + 3);
    }

    public static void m(double param) {
        System.out.println("1");
    }

    public static void m(float param) {
        System.out.println("2");
    }
}
