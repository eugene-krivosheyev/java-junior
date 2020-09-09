package com.acme.edu.message;

import com.acme.edu.saver.Saver;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IntMessageTest {

    @Test
    public void shouldAccumalateWithoutOverflow() {
        IntMessage message = new IntMessage(1);

        message.accumulateMessage(new IntMessage(2));

        assertTrue(message.getMaxIntValueAmount() == 0);
        assertTrue(message.getCurrentIntMessage() == 3);
    }

    @Test
    public void shouldAccumalateWithOverflow(){
        IntMessage message = new IntMessage(1);

        message.accumulateMessage(new IntMessage(Integer.MAX_VALUE));

        assertTrue(message.getMaxIntValueAmount() == 1);
        assertTrue(message.getCurrentIntMessage() == 1);
    }

    @Test
    public void shouldCreateMessageWithPrefix() {
        IntMessage message = new IntMessage(1);
        String actual = message.createMessageWithPrefix();

        assertEquals(actual, "primitive: 1");
    }

    @Test
    public void shouldCreateMessageWithOverflowWithPrefix() {
        IntMessage message = new IntMessage(Integer.MAX_VALUE);
        String actual = message.createMessageWithPrefix();

        assertEquals(actual, "primitive: "+Integer.MAX_VALUE);
    }

    @Test
    public void shouldBeSameType() {
        IntMessage message = new IntMessage(1);
        LoggerMessage loggerMessage = new IntMessage(2);

        boolean same = message.isSameType(loggerMessage);
        assertTrue(same);
    }

    @Test
    public void shouldNotBeSameType() {
        IntMessage message = new IntMessage(1);
        LoggerMessage loggerMessage = mock(StringMessage.class);

        boolean same = message.isSameType(loggerMessage);
        assertFalse(same);
    }

    @Test
    public void shouldPrintWithoutOverflow() {
        Saver saver = mock(Saver.class);
        IntMessage message = new IntMessage(1);

        message.printMessageBuffer(saver);
        verify(saver).print("primitive: 1");
    }


}


