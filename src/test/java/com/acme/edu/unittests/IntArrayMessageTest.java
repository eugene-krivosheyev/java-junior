package com.acme.edu.unittests;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.IntArrayMessage;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntArrayMessageTest {
    private Decorator stubDecorator = mock(DefaultDecorator.class);

    public void testGetDecoratedMessage(int[] testArray, String nonDecoratedArrayAsString) {
        String stubResult = "primitives array: {" + nonDecoratedArrayAsString + "}"
                + System.lineSeparator();
        when(stubDecorator.getDecoratedMessage()).thenReturn(stubResult);
        IntArrayMessage sut = new IntArrayMessage(testArray, stubDecorator);
        assertEquals(stubResult, sut.getDecoratedMessage());
    }

    @Test
    public void shouldDecorateEmptyArray() {
        int[] emptyArray = new int[0];
        testGetDecoratedMessage(emptyArray, System.lineSeparator());

    }

    @Test
    public void shouldDecorateNonEmptyArrayWithOneElement() {
        int[] emptyArray = {1};
        testGetDecoratedMessage(emptyArray, "1");
    }

    @Test
    public void shouldDecorateNonEmptyArrayWithMultipleElements() {
        int[] emptyArray = {1,2,3};
        testGetDecoratedMessage(emptyArray, "1, 2, 3");
    }
}
