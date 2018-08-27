package com.acme.edu.decorators;

/**
 * Created by Java_12 on 27.08.2018.
 */
public class ArrayDecorator implements Decorator {
    @Override
    public String decorate(String... values) {
        String buffer = "primitives array: ";
        buffer += "{";
        for (int current = 0; current < values.length-1; current++) {
            buffer += values[current] + ", ";
        }
        if (values.length > 0) {
            buffer += values[values.length-1];
        }
        buffer += "}";
         return buffer;
    }
}
