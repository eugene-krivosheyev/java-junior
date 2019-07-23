package com.acme.edu.functional;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        ChangeAndGetStateable result = outer.m();
    }
}

/**
 * Top-level
 */
class Outer {
    private static int staticOuterState = 0;
    private int instanceOuterState = 0;

    public ChangeAndGetStateable m() {
        int localVar = 0;

        class Inner implements ChangeAndGetStateable {
            private int innerState = 0;

            public int changeAndGetState() {
                innerState = 1;
                staticOuterState = 1;
                Outer.this.instanceOuterState = 1;

                System.out.println(localVar); //!!

                return innerState;
            }
        }

        return new Inner();
    }
}

interface ChangeAndGetStateable {
    int changeAndGetState();
}

