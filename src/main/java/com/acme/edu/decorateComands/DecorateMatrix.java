package com.acme.edu.decorateComands;

public class DecorateMatrix implements DecorateArray {
    public String decorate(int[][] message){
        return DecorateArray.collectData(message)
                .replace("[", "{")
                .replace("]", "}");
    }
}
