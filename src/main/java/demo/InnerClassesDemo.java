package demo;

import demo.ooad.Filter;
import demo.ooad.Saver;
import demo.ooad.LoggerController;
import demo.ooad.Message;

public class InnerClassesDemo {
    public static void main(String[] args) {
        new LoggerController(
                new SaverAdapter() {
                    @Override
                    public Number save(String message) {
                        return 0;
                    }
                },
                new Filter() {
                    @Override
                    public boolean filter(Message message) {
                        return false;
                    }
                }
        );

        int localVar = 1;
        //CLOSURE!!!!
        templateMethod(new ToDo() {
            @Override
            public void todo() {
                System.out.println("look ma, HOF! " + localVar);
            }
        });
    }

    public static void templateMethod(ToDo todo) {
        //....
        //....
        todo.todo();
        //....
        //....
    }
}

interface ToDo {
    void todo();
}

class TopLevel {
    private static int classState;
    private int instanceState;

    class Inner {
        public void m() {
            classState = 1;
            TopLevel.this.instanceState = 1;
        }
    }
}
