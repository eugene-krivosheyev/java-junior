package com.acme.edu.innerclasse;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.new Inner();
        outer.new Inner().new InnerInnerClass();
    }
}


class Outer {
    private int outerState;
    protected class Inner {

        class InnerInnerClass {
            void m() {
                System.out.println(outerState);
                System.out.println(Outer.this.outerState);
            }
        }

        void m() {
            System.out.println(outerState);
        }
    }
}