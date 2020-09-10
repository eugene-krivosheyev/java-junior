package demo.innernestedlocal;

import refactoring.message.Message;
import refactoring.save.Saver;

public class InnerNestedLocalDemo {
    Saver saver = System.out::println;

    public static void main(String[] args) {
        Outer.StaticInner o1 = new Outer.StaticInner();
        System.out.println(o1.mutateAndGetOuterStaticState());
        System.out.println(o1.mutateAndGetOuterStaticState());

        final Outer outer = new Outer();
        Outer.Nested nested = outer.new Nested();
        outer.new Nested();
        outer.new Nested();

        final Outer.Nested nested1 = new Outer().new Nested();

        String localVar = "1";
        Object printable = new Object() {
            @Override //Closure
            public String toString() {
                int localLolaVar = 0;
                localLolaVar = 1;
                return localVar;
            }
        };
//        AnothrObject.setPrintable(printable);
    }
}

class Outer {
    private static int outerStaticState;
    private int outerObjectState;
    int outerVar = 9;

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
        int localVar = 9;

        return new Saver() {
            @Override
            public void save(Message message) {
                int localVar = 0;
                //...
                System.out.println("SAVE!!!");
            }
        };
    }
}

class DuplicationDetected {
    public void m1() {
        //...
//        ???
        //...
    }

    public void m2() {
        //...
//        ???
        //...
    }

    // ------------------

    public void m(Todo todo) {
        //...
        todo.todo();
        //...
    }

    public static void main(String[] args) {
        //m1() | m2()
        new DuplicationDetected().m(() -> System.out.println("Implementation 1"));
    }
}

@FunctionalInterface
interface Todo {
    void todo();
}