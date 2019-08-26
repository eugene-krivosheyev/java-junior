package com.acme.edu.commands;

public class MultiMatrixDecorator implements DecorateArray {
    @Override
    public String decorate(int[][] message) {
        return DecorateArray.collectData(message)
                .replace("[", "{\n")
                .replace("]", "\n}");
    }
}
