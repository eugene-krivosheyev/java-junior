package com.acme.edu.unittests;

import com.acme.edu.message.Int2DimArrayMessage;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Int2DimArrayMessageTest {
    Decorator stubDecorator = new DefaultDecorator("primitives matrix");

    @Test
    public void getDecoratedNonEmptyInt2DimArray() {
        int[][] testArray = {{1, 2, 3}, {4, 5, 6}};
        Int2DimArrayMessage sut = new Int2DimArrayMessage(testArray, stubDecorator);
        assertEquals(String.format("primitives matrix: {%1$s{1, 2, 3}%1$s{4, 5, 6}%1$s}%1$s", System.lineSeparator()),
                sut.getDecoratedMessage());

    }
}
