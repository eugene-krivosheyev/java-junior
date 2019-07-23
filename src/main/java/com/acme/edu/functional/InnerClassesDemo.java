package com.acme.edu.functional;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer.Inner io = new Outer.Inner();
        io.changeAndGetState();
    }
}

/**
 * Top-level
 */
class Outer {
    private static int staticOuterState = 0;
    private int instanceOuterState = 0;

    static class Inner {
        private int innerState = 0;

        public int changeAndGetState() {
            innerState = 1;
            staticOuterState = 1;
            return innerState;
        }
    }
}


