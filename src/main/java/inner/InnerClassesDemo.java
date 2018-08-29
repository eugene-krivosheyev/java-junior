package inner;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();
        obj.m();
    }
}

class Outer {
    private static int i = 0;

    static class Inner {
        void m() {
            i = 1;
        }
    }
}
