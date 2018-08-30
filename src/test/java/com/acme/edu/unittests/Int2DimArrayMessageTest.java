package com.acme.edu.unittests;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.Int2DimArrayMessage;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Int2DimArrayMessageTest {
    private Decorator stubDecorator = mock(DefaultDecorator.class);

    @Test
    public void getDecoratedNonEmptyInt2DimArray() throws LoggerDecoratorException {
        int[][] testArray = {{1, 2, 3}, {4, 5, 6}};
        String stubResultString = String.format("primitives matrix: {%1$s{1, 2, 3}%1$s{4, 5, 6}%1$s}%1$s",
                System.lineSeparator());
        when(stubDecorator.getDecoratedMessage()).thenReturn(stubResultString);
        Int2DimArrayMessage sut = new Int2DimArrayMessage(testArray, stubDecorator);
        assertEquals(stubResultString, sut.getDecoratedMessage());

    }
}
