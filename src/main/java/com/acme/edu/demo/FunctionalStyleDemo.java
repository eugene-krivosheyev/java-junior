package com.acme.edu.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toSet;

public class FunctionalStyleDemo {
    public static void main(String[] args) {
        template(() -> System.out.println("HW!"));

        Optional<Integer> maybeInt = Optional.of(1);
        sumOfElementsFromDB(maybeInt);

        final String reducedResult =
            Stream.of(1, 9, 2, 8, 3, 7, 4, 6, 5).parallel()
                .map(Math::decrementExact)
                .filter(e -> e < 6)
                .map(Object::toString)
                .sorted(reverseOrder())
                .skip(4).limit(2)
            .collect(Collectors.joining(","));
//            .forEach(System.out::println);
//            .collect(toSet())
//            .reduce("", (s, s2) -> s + s2);

        System.out.println(reducedResult);
    }

    static int sumOfElementsFromDB(Optional<Integer> maybeSalary) {
        return maybeSalary
                .orElseThrow(IllegalStateException::new);
    }

    static void template(ToDo todo) {
        //.....
        todo.todo();
        //.....
    }
}

@FunctionalInterface
interface ToDo {
    void todo();
}