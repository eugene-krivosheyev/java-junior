package com.acme.edu.decorators;

/**
 * Created by Java_12 on 27.08.2018.
 */
public class ObjectDecorator implements Decorator {
    @Override
    public String decorate(String... values) {
        return "reference: " + values[0];
    }
}
