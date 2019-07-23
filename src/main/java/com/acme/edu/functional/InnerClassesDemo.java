package com.acme.edu.functional;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner oi = outer.new Inner();
    }
}

/**
 * Top-level
 */
class Outer {
    private static int staticOuterState = 0;
    private int instanceOuterState = 0;

    class Inner {
        private int innerState = 0;

        public int changeAndGetState() {
            innerState = 1;
            staticOuterState = 1;
            Outer.this.instanceOuterState = 1;
            return innerState;
        }
    }
}


