package com.acme.edu.facadetests;

import com.acme.edu.Logger;
import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoggerTest {
    @Test
    public void shouldSuccessfullyLogInt() throws LoggerDecoratorException {
        assertEquals(0, Logger.log(0));
    }

    @Test
    public void shouldSuccessfullyLogByte() throws LoggerDecoratorException {
        assertEquals(0, Logger.log((byte) 0));
    }

    @Test
    public void shouldSuccessfullyLogString() throws LoggerDecoratorException {
        assertEquals(0, Logger.log("test"));
    }

    @Test
    public void shouldSuccessfullyLogChar() throws LoggerDecoratorException {
        assertEquals(0, Logger.log('t'));
    }

    @Test
    public void shouldSuccessfullyLogBoolean() throws LoggerDecoratorException {
        assertEquals(0, Logger.log(true));
    }

    @Test
    public void shouldSuccessfullyLogIntArray() throws LoggerDecoratorException {
        assertEquals(0, Logger.log(new int[]{1, 2, 3}));
    }

    @Test
    public void shouldSuccessfullyLogInt2DimArray() throws LoggerDecoratorException {
        assertEquals(0, Logger.log(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    @Test
    public void shouldSuccessfullyLogObject() throws LoggerDecoratorException {
        assertEquals(0, Logger.log(new Object()));
    }

    @Test(expected = LoggerDecoratorException.class)
    public void shouldNotSuccessfullyFlushAsIsEmpty() throws LoggerDecoratorException {
        assertEquals(0, Logger.flush());
    }
}
