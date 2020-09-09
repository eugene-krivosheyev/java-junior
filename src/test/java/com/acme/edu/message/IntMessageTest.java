package com.acme.edu.message;

import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IntMessageTest {
    private static IntMessage message;
    @Before
    public void setUp() {
        message = new IntMessage(1);
    }

    @Test
    public void shouldAccumalateWithoutOverflow() {
        message.accumulateMessage(new IntMessage(2));

        assertTrue(message.getMaxIntValueAmount() == 0);
        assertTrue(message.getCurrentIntMessage() == 3);
    }

    @Test
    public void shouldAccumalateWithOverflow(){
        message.accumulateMessage(new IntMessage(Integer.MAX_VALUE));

        assertTrue(message.getMaxIntValueAmount() == 1);
        assertTrue(message.getCurrentIntMessage() == 1);
    }

    @Test
    public void shouldCreateMessageWithPrefix() {
        String actual = message.createMessageWithPrefix();

        assertEquals(actual, "primitive: 1");
    }

    @Test
    public void shouldCreateMessageWithOverflowWithPrefix() {
        message = new IntMessage(Integer.MAX_VALUE);
        String actual = message.createMessageWithPrefix();

        assertEquals(actual, "primitive: "+Integer.MAX_VALUE);
    }

    @Test
    public void shouldBeSameType() {
        LoggerMessage sameTypeMessage = new IntMessage(2);

        assertTrue(message.isSameType(sameTypeMessage));
    }

    @Test
    public void shouldNotBeSameType() {
        LoggerMessage notSameTypeMessage = mock(StringMessage.class);

        assertFalse(message.isSameType(notSameTypeMessage));
    }

    @Test
    public void shouldPrintWithoutOverflow() {
        Saver mock = mock(Saver.class);

        message.printMessageBuffer(mock);
        verify(mock).print("primitive: 1");
    }

    @Test
    public void shouldPrintWithOverflow() {
        Saver mock = mock(Saver.class);
        message.accumulateMessage(new IntMessage(Integer.MAX_VALUE));

        message.printMessageBuffer(mock);
        verify(mock).print("primitive: 1");
        verify(mock).print("primitive: " + Integer.MAX_VALUE);
    }
}


