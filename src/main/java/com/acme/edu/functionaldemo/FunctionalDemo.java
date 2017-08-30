package com.acme.edu.functionaldemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;

public class FunctionalDemo {
    public static void main(String[] args) {
        int limit = 9;
        Arrays.asList(1, 6, 3, 2, 8, 2, 3, 10).stream()
            .sorted(reverseOrder())
            .filter(new Predicate<Integer>() {
                @Override
                public boolean test(Integer integer) {
                    return integer < limit;
                }
            })
            .map(e -> e + "0")
                .forEach(System.out::println);
    }
}
