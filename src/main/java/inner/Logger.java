package inner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

class LoggerApp {
    public static void main(String[] args) {
        String mesasge = "test message";
        int severity = 6;

        /*
        new Logger().log(
            () -> severity < 5,
            () -> System.out.println(mesasge)
        );
        */

        Collection<Integer> list = Arrays.asList(1,4,2,3);
        Stream<String> sorted = list.parallelStream()
            .map(integer -> integer + "1")
            .filter(e -> !"11".equals(e))
            .sorted(reverseOrder());

        sorted
            .collect(toList())
            .forEach(System.out::println);

    }
}

/*
class Logger {
    public void log(Filter filter, Saver saver) {
        if (!filter.filter(message, severity)) {
            saver.save(message);
        }
    }
}

@FunctionalInterface
interface Saver {
    void save(SaveSuccessEvent todo);
}

@FunctionalInterface
interface SaveSuccessEvent {
    void handle();
}

@FunctionalInterface
interface Filter {
    boolean filter();
}
*/