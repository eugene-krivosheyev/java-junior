package demo.innernestedlocal;

import refactoring.message.Message;
import refactoring.save.Saver;

public class InnerNestedLocalDemo {
    public static void main(String[] args) {
        Outer.StaticInner o1 = new Outer.StaticInner();
        System.out.println(o1.mutateAndGetOuterStaticState());
        System.out.println(o1.mutateAndGetOuterStaticState());

        final Outer outer = new Outer();
        Outer.Nested nested = outer.new Nested();
        outer.new Nested();
        outer.new Nested();

        final Outer.Nested nested1 = new Outer().new Nested();


        outer.getObjectImpl().m
    }
}

class Outer {
    private static int outerStaticState;
    private int outerObjectState;

    static class StaticInner {
        public int mutateAndGetOuterStaticState() {
            int outerStaticState = 0;
            Outer.outerStaticState++;
            return outerStaticState;
        }
    }

    class Nested {
        private int nestedObjectState;

        public int mutateAndGetOuterObjectState() {
            int outerObjectState = 0;
            return Outer.this.outerObjectState++;
        }
    }

    public Saver getObjectImpl() {
        class Local implements Saver {
            private int objectState;

            @Override
            public void save(Message message) {

            }

            public int m() {
                return objectState++;
            }
        }

        return new Local();
    }
}
