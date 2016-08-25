package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Logger {
    /**
     * Creational Patterns
     */
    private final Filter filter; //DI
    private final Saver saver = SaverFactory.create();
    private final Decorator decorator = null;

    public Logger(Filter filter) {
        this.filter = filter;
    }

    public Decorator log(String message) {
        if (filter.filter(message)) {
            saver.save(decorator.decorate(message));
        }

        int i = 7;

        return mes -> mes + "!!!!" + i;
    }
}

class Client {
    public static void main(String[] args) {
        final Logger logger = new Logger(new Filter() {
            private int i;
            @Override
            boolean filter(String message) {

                return false;
            }
        });


        Arrays.asList(1,2,3,4,5).parallelStream()
            .filter(e -> e > 1)
            .map(e -> "" + e + "!!!")
            .collect(Collectors.toList());

    }
}




