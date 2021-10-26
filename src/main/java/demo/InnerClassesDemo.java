package demo;

import demo.ooad.Filter;
import demo.ooad.Saver;
import demo.ooad.LoggerController;
import demo.ooad.Message;

import java.util.Set;

public class InnerClassesDemo {
    public static void main(String[] args) {
        new LoggerController(
                new SaverAdapter() {
                    @Override
                    public Number save(String message) {
                        return 0;
                    }
                },
                message -> message.equals("???")
        );

        int localVar = 1;
        //CLOSURE!!!!
        templateMethod(() -> System.out.println("look ma, HOF! " + localVar));

        FI variable = (String arg1, int arg2) -> {
            //.....
            //.....
            //.....
            //.....
        };

        variable = (arg1, arg2) -> System.out.println(arg1);

        FIMR lambda = arg -> System.out.println(arg); // lambda = System.out.println
        lambda = System.out::println;

        Set.of(1,2,3).parallelStream()
                .map(e -> e + 1)
                .filter(e -> e < 2)
                .forEach(System.out::println);
    }

    public static void templateMethod(ToDo todo) {
        //....
        //....
        todo.todo();
        //....
        //....
    }
}

interface FIMR {
    void m(String arg);
}

interface FI {
    void m(String arg1, int arg2);
}

//@FunctionalInterface
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
