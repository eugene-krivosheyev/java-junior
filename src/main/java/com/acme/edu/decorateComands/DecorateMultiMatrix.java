package com.acme.edu.decorateComands;

public class DecorateMultiMatrix implements DecorateArray {
    @Override
    public String decorate(int[][] message) {
        return DecorateArray.collectData(message)
                .replace("[", "{\n")
                .replace("]", "\n}");
    }
}
