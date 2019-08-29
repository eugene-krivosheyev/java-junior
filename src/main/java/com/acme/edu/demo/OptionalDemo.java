package com.acme.edu.demo;

import java.util.stream.Stream;

public class OptionalDemo {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
            .reduce(Math::addExact)
            .ifPresent(result -> flush(result));

//        accumulatedCommand.orElse(null).flush(saver);
    }

    private static void flush(Integer result) {

    }
}
