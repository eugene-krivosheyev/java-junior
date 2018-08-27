package com.acme.edu.decorators;

/**
 * Created by Java_12 on 27.08.2018.
 */
public class StringDecorator implements Decorator {
    @Override
    public String decorate(String... values) {
        return "string: " + values[0] + " (x" + values[1] + ")";
    }
}
