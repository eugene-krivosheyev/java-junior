package com.acme.edu.unittests;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DefaultDecoratorTest {

    @Test
    public void shouldCreateDecoratorWithNonEmptyType() throws LoggerDecoratorException {
        DefaultDecorator sut = new DefaultDecorator("primitive");
        assertNotNull(sut);
        assertEquals("primitive", sut.getType());
    }

    @Test (expected = LoggerDecoratorException.class)
    public void shouldNotCreateDecoratorWithNullType() throws LoggerDecoratorException {
        DefaultDecorator sut = new DefaultDecorator(null);
    }

    @Test (expected = LoggerDecoratorException.class)
    public void shouldNotCreateDecoratorWithEmptyType() throws LoggerDecoratorException {
        DefaultDecorator sut = new DefaultDecorator("");
    }
}
