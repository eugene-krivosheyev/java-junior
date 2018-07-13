package demo.functional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
//        Outer.outerInstanceState ???
        Outer outer = new Outer();
        Saver saver = outer.factoryMethod();
        saver.save("", "");

        new MyLogger(
            (p, severity) -> outer.doThm(p)
        );

        System.out.println("=================");
        Collection<Integer> list = Arrays.asList(1,7,2,6,3,5,4);
        list.stream()
                .map(param -> param + 1)
                .filter(integer -> integer < 5)
                .sorted((e1,e2) -> e2 - e1)
        .forEach(System.out::println);


        new FluentInterface() //Chaining
                    .operation()
                    .operation()
                    .operation();
    }
}

class FluentInterface {
    FluentInterface operation() {
        return this;
    }
}

/**
 * Top-level class
 */
class Outer {
    private int outerInstanceState = 0;

    public Saver factoryMethod() {
        int outerMethodLocalVar = 0;

       return new Saver() {
           @Override //Closure
           public void save(String message, String severity) {
               Outer.this.outerInstanceState = 1;
               System.out.println(outerMethodLocalVar);
//               outerMethodLocalVar = 5;
           }
       };
    }


    void doThm(String p) {

    }
}

@FunctionalInterface
interface Saver {
    //Closure
    void save(String message, String severity);
}

class MyLogger {
    private Saver saver;

    MyLogger(Saver saver) {
        this.saver = saver;
    }
}