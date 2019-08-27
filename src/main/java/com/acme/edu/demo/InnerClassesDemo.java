package com.acme.edu.demo;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        Outer.Inner inn = new Outer().new Inner();

    }
}

class Outer {
    private static int staticState = 1;
    private int shadedInstanceState = 2;

    public class Inner {
        public void m(int shadedInstanceState) {
            staticState = 2;
            System.out.println(staticState);
            new Outer();

            Outer.this.shadedInstanceState = 3;
        }
    }
}