package demo.innerclasses;

public class Demo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner obj1 = outer.new Inner();
    }
}

class Outer {
    private int instanceState = 0;
    private static int classState;

    private class Inner {
        private int instanceState = 0;
        void im() {
            System.out.println(Outer.this.instanceState);
        }
    }
}