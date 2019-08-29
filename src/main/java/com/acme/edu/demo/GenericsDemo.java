package com.acme.edu.demo;

import com.acme.edu.ooaddemo2.IntCommand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unchecked")
public class GenericsDemo {
    public static void main(String[] args) {
        final Optional<Integer> maybeObject = Optional.<Integer>of(1);

        final Object o = maybeObject.get();
        if (o instanceof Integer) {
            final Integer i = (Integer) o;
        }
        maybeObject.get().intValue();

        List<? extends String> list = new ArrayList<>();
        list.get(0).toUpperCase();

        new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        List<String> list1 = new ArrayList();
    }
}

class Optional<T extends Number & Serializable> {
    private T body;

    private Optional(T body) {
        this.body = body;
    }

    public static <T extends Number> Optional of(@NotNull T body) {
        body.byteValue();
        return new Optional<>(body);
    }

    public static <T extends Number> Optional ofNullable(@Nullable T body) {
        return new Optional<>(body);
    }


    public T get() {
        return body;
    }

    //.......
}

interface Comparable<T> {
    int compare(T o);
}

class MyInteger1 implements Comparable { // T = Object
    @Override
    public int compare(Object o) {
        return 0;
    }
}

class MyInteger2<T> implements Comparable<T> { //MyInteger<String>
    @Override
    public int compare(T o) {
        return 0;
    }
}

class MyInteger3 implements Comparable<String> {
    @Override
    public int compare(String o) {
        return 0;
    }
}
