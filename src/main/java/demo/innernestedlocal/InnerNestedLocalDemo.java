package demo.innernestedlocal;

import refactoring.save.Saver;

public class InnerNestedLocalDemo {
    public static void main(String[] args) {
        Outer.StaticInner o1 = new Outer.StaticInner();
        System.out.println(o1.mutateAndGetOuterStaticState());
        System.out.println(o1.mutateAndGetOuterStaticState());
    }
}

class Outer {
    private static int outerStaticState;

    static class StaticInner {
        public int mutateAndGetOuterStaticState() {
            int outerStaticState = 0;
            Outer.outerStaticState++;
            return outerStaticState;
        }
    }
}
