package demo;

public class RefDemo {
    static Object classVar = new Object();
    Object instVar = new Object();


    public static void main(String[] args) {
        Object o = new Object();
        Object o1 = o;
        o = null;
        o = new Object();

        m();
        System.out.println(o);
    }

    private static void m() {
        Object o = new Object();
    }
}
