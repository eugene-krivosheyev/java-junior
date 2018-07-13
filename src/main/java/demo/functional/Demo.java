package demo.functional;


public class Demo {
    public static void main(String[] args) {
//        Outer.state ???
        Outer.Inner obj = new Outer.Inner();
        obj.m();

    }
}

/**
 * Top-level class
 */
class Outer {
    private static int state = 0;

    public static class Inner {
        void m() {
            state = 1;
        }
    }
}
