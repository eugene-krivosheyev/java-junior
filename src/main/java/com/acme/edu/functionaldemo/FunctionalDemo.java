package com.acme.edu.functionaldemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;

public class FunctionalDemo {
    public static void main(String[] args) {
        int limit = 9;
        Arrays.asList(1, 6, 3, 2, 8, 2, 3, 10).stream()
            .sorted(reverseOrder())
            .filter(integer -> integer < limit)
            .map(e -> e + "0")
                .forEach(System.out::println);

        Logger logger = new Logger();
        logger.addEventHandler(() -> {});
        logger.addEventHandler(FunctionalDemo::callTovMayor);
        logger.addEventHandler(() -> {
            System.out.println(limit);
        });
        logger.fireEvent();
    }

    private static void callTovMayor() {

    }

    private static void callSaoul() {

    }
}

class Logger {
    private Set<LoggerEventHandler> handlers = new HashSet();

    public void addEventHandler(LoggerEventHandler handler) {
        handlers.add(handler);
    }

    public void fireEvent() {
        handlers.forEach(LoggerEventHandler::notifyEvent);
    }
}

@FunctionalInterface
interface LoggerEventHandler {
    void notifyEvent();
}