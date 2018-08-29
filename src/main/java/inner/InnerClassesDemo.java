package inner;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner1 = outer.new Inner();
        Outer.Inner inner2 = outer.new Inner();
        inner1.m();
        inner2.m();

        System.out.println(outer.getI());
    }
}

class Outer {
    private int i = 0;

    public int getI() {
        return i;
    }

    class Inner {
        void m() {
            Outer.this.i = 1;
        }
    }
}
