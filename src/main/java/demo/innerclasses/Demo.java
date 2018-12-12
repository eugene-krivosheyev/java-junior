package demo.innerclasses;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class Demo {
    private static int classState;
    private int instanceState;

    public static void main(String[] args) {
        final int localVar = 0;
        new LLogger(
            System.out::println,
            (message, level) -> level < 5
        );

        List<Integer> list = Arrays.asList(6,1,5,2,4,3);
        list.stream()
                .filter(e -> e < 4)
                .sorted(comparingInt(e2 -> e2))
                .map(Object::toString)
            .forEach(System.out::println);
    }
}

class LLogger {
    private LSaver lSaver;
    private LFilter lFilter;

    public LLogger(LSaver lSaver, LFilter lFilter) {
        this.lSaver = lSaver;
        this.lFilter = lFilter;
    }
}

@FunctionalInterface
interface LSaver {
    void save(String message);
}

@FunctionalInterface
interface LFilter {
    boolean filter(String message, int level);
}