package com.acme.edu.testing;

import com.acme.edu.decorator.PrefixDecorator;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixDecoratorTest {
    @Test
    public void decorateString() {
        String expected = "string: Very Important String";
        PrefixDecorator prefixDecorator = new PrefixDecorator();
        String result = prefixDecorator.decorate("Very Important String");
        assertEquals(expected, result);
    }
    @Test
    public void decorateInt() {
        String expected = "primitive: 614456";
        PrefixDecorator prefixDecorator = new PrefixDecorator();
        String result = prefixDecorator.decorate(614456);
        assertEquals(expected, result);
    }
    @Test
    public void decorateChar() {
        String expected = "char: T";
        PrefixDecorator prefixDecorator = new PrefixDecorator();
        String result = prefixDecorator.decorate('T');
        assertEquals(expected, result);
    }
    @Test
    public void decorateByte() {
        String expected = "primitive: 127";
        PrefixDecorator prefixDecorator = new PrefixDecorator();
        String result = prefixDecorator.decorate(127);
        assertEquals(expected, result);
    }
    @Test
    public void decorateBoolean() {
        String expected = "primitive: false";
        PrefixDecorator prefixDecorator = new PrefixDecorator();
        String result = prefixDecorator.decorate(false);
        assertEquals(expected, result);
    }
}
