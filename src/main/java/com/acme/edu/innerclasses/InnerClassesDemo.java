package com.acme.edu.innerclasses;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InnerClassesDemo {
    private static int staticState;
    private int outerInstanceState;

    public static void main(String[] args) {
        Outer.StaticInner si = new Outer.StaticInner();

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        inner.m(0);
        outer.new Inner();
        outer.new Inner();

//        System.out.println(getObjectOfLocalClass());

        getInstanceOfLocalAnonymousClass().print();

        new Controller(
                new Saver() {
                    @Override
                    public void save() {
                        System.out.println();
                    }
                },
                new Saver() {
                    @Override
                    public void save() {
                        System.out.println("ffff");
                    }
                }
        );
    }

    public Object getObjectOfLocalClass() {
        class LocalClass extends Object {
            private int innerInstanceState;

            @Override
            public String toString() {
                int localState;
                return staticState + " " + outerInstanceState;
            }
        }

        return new LocalClass();
    }

    public static Printable getInstanceOfLocalAnonymousClass() {
        return new Printable() {
            private int state;

            @Override
            public void print() {
                System.out.println(state);
            }
        };
    }
}

interface Printable {
    void print();
}

class Outer {
    private static int staticState;
    private int state;

    static class StaticInner {
        public void m() {
            staticState = 0;
        }
    }

    class Inner {
        private int state;

        public void m(int state) {
            System.out.println(Outer.this.state);
        }
    }
}

class Controller {
    private List<Saver> savers = new ArrayList<>();

    public Controller(Saver... savers) {
        this.savers.addAll(Arrays.asList(savers));
    }
}

interface Saver {
    void save();
}
