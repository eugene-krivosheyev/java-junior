package com.acme.edu;

import java.util.Arrays;
import java.util.stream.Stream;

public class Utils {
    private static Stream<Object> flatten(Object[] array) {
        return Arrays.stream(array)
                .flatMap(o -> o instanceof Object[] ? flatten((Object[])o) : Stream.of(o));
    }

    public static Object[] getFlatArray(Object[] array) {
        return flatten(array).toArray();
    }
}
