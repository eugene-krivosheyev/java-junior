package demo.innerclasses;

public class Demo {
    public static void main(String[] args) {
        Outer.Inner obj =
                new Outer.Inner();
    }
}


class Outer {
    private int instanceState;
    private static int classState;

    static class Inner {
        void im() {
            System.out.println(classState);
        }
    }

    void om() {
    }
}