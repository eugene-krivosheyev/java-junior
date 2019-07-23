package com.acme.edu.functional;

import com.acme.edu.ooad.*;

import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        ChangeAndGetStateable result = outer.m();

        LogSaver mySavingFunction = message -> null;
        new Logger(
                new LogSeverityLevelFilter(5),
                mySavingFunction
        );

        Stream.of(1,6,2,5,3,4)
            .filter(e -> e % 2 == 0)
            .map(String::valueOf)
            .sorted(comparingInt(String::length))
                .forEach(System.out::println);
    }
}

/**
 * Top-level
 *
 */
class Outer {
    private static int staticOuterState = 0;
    private int instanceOuterState = 0;

    public ChangeAndGetStateable m() {
        final int localVar = fm();

        ChangeAndGetStateable closure = new ChangeAndGetStateable() {
            @Override
            public int changeAndGetState() {
                System.out.println(localVar);
                return localVar + 1;
            }
        };
        //Registry.register(closure);

        return closure;
    }

    private int fm() {
        return 0;
    }
}

interface ChangeAndGetStateable {
    int changeAndGetState();
}

