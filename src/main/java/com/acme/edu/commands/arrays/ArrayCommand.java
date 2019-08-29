package com.acme.edu.commands.arrays;

import com.acme.edu.commands.Command;
import java.util.Arrays;

abstract class ArrayCommand implements Command<String> {
    private static final String PRIMITIVE_PREFIX_FOR_ARRAY = "primitives array: ";
    private static final String PRIMITIVE_PREFIX_FOR_MATRIX = "primitives matrix: ";
    private static final String PRIMITIVE_PREFIX_FOR_MULTI_MATRIX = "primitives multimatrix: ";


    String decorateArray(int[] array) {
        return PRIMITIVE_PREFIX_FOR_ARRAY + Arrays.toString(array).replace("[", "{").replace("]", "}") + "\n";
    }

    String decorateArray(int[][] array) {
        StringBuilder result = new StringBuilder("{\n");
        for (int[] anArray : array)
            result.append(Arrays.toString(anArray).replace("[", "{").replace("]", "}")).append("\n");
        return PRIMITIVE_PREFIX_FOR_MATRIX + result + "}";
    }

    String decorateArray(int[][][][] array) { return PRIMITIVE_PREFIX_FOR_MULTI_MATRIX + Arrays.deepToString(array).replace("[", "{\n").replace("]", "\n}"); }
}
