package com.acme.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Logger {
    private int i;

    public Comparator m(int param) {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                i = 8;
                System.out.println(param);
                return 0;
            }
        };
    }
}

class Main {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        c.stream()
            .map( Object::toString )
            .filter( e -> e.length() < 80 )
            .forEach( System.out::println );
    }
}







