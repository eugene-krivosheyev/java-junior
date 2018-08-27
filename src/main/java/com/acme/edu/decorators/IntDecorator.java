package com.acme.edu.decorators;

/**
 * Created by Java_12 on 27.08.2018.
 */
public class IntDecorator implements Decorator {
    @Override
    public String decorate(String... values) {
        return "primitive: " + values[0];
    }
}
