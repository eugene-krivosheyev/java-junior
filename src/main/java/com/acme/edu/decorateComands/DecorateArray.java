package com.acme.edu.decorateComands;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface DecorateArray {
    static String collectData(int[][] message) {
        return "{\n" +
                Arrays.stream(message)
                .map(Arrays::toString)
                .collect(Collectors.joining("\n")) +
                "\n}";
    }

    String decorate(int[][] message);
}
