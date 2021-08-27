package demo;

import demo.ooad.controller.LoggerController;
import demo.ooad.dao.Saver;
import demo.ooad.domain.Message;
import demo.ooad.domain.SeverityLevel;
import demo.ooad.filter.Filter;

public class InnerNestedClassesDemo {
    public static void main(String[] args) {
        Outer.StaticInner obj = new Outer.StaticInner();

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        System.out.println(new Outer().outerMethod());
        System.out.println(new Outer().outerFactoryMethod());

        Saver saver = new Saver() {
            @Override
            public void save(Message message) {
                System.out.println(message);
            }
        };

        LoggerController controller = new LoggerController(
                new Filter() {
                    @Override
                    public boolean filter(Message message) {
                        return false;
                    }
                },

                new Saver() {
                    @Override
                    public void save(Message message) {
                        System.out.println(message);
                    }
                }
        );

        controller.log(new Message("123", SeverityLevel.ERROR));


        int localVar = 0;
        // High - order function
        m(new Todo() {
            @Override
            public void act(String m) {
                System.out.println(localVar);
                System.out.println("2-1");
            }
        });

        int var = 0;
        m( message -> System.out.println(message) );
        m( System.out::println ); // method reference: "apply f to arg | call from arg"

        m( message -> message.isEmpty() );
        m( String::isEmpty );
    }

    static void m(Todo todo) {
        //1
        todo.act("HW!!!!");
        //3
    }

    static void m1() {
        //1
        //2-1
        //3
    }

    static void m2() {
        //1
        //2-2
        //3
    }
}

@FunctionalInterface
interface Todo {
    void act(String message);
}

class Outer {
    private static int staticOuterState = 1;
    private int instanceOuterState1 = 1;

    static class StaticInner {
        public void m() {
            staticOuterState = 2;
        }
    }

    class Inner {
        int instanceOuterState;

        public void m() {
            int instanceOuterState = 0;
            instanceOuterState = 2;

            this.instanceOuterState = 2;

            Outer.this.instanceOuterState1 = 8;
        }
    }

    public Object outerMethod() {
        class Nested extends Object {
            @Override
            public String toString() {
                return "!!!!!!";
            }
        }
        return new Nested();
    }

    public Object outerFactoryMethod() {
        return new Object() {
            @Override
            public String toString() {
                return "???????";
            }
        };
    }

    static void m() {
        int localVar = 0;
        //.....
        //.....
//        run( { localVar } )
        //.....
        //.....
    }

}
