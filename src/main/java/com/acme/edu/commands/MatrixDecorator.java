package com.acme.edu.commands;

public class MatrixDecorator implements DecorateArray {
    public String decorate(int[][] message){
        return DecorateArray.collectData(message)
                .replace("[", "{")
                .replace("]", "}");
    }
}
