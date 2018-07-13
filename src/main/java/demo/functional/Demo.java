package demo.functional;


public class Demo {
    public static void main(String[] args) {
//        Outer.outerInstanceState ???
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
    }
}

/**
 * Top-level class
 */
class Outer {
    private int outerInstanceState = 0;

    public class Inner {
        void m() {
            Outer.this.outerInstanceState = 1;
        }
    }
}
