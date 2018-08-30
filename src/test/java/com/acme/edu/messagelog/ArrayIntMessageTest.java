package com.acme.edu.messagelog;

import com.acme.edu.loggerexceptions.AccumulateException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayIntMessageTest {
    private ArrayIntMessage arrayIntMessage;

    @Before
    public void setUp() throws Exception {
        arrayIntMessage = new ArrayIntMessage(1, 2, 3);
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedWithOtherMessageType() {
        IntMessage dummyIntMessage = mock(IntMessage.class);

        assertFalse(arrayIntMessage.canBeAccumulated(dummyIntMessage));
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedWithArrayIntMessage() {
        ArrayIntMessage dummyArrayIntMessage = mock(ArrayIntMessage.class);

        assertFalse(arrayIntMessage.canBeAccumulated(dummyArrayIntMessage));
    }

    @Test
    public void shouldReturnDecoratedMessageWhenCallGetFormattedString() {
        LoggerDecorator stubLoggerDecorator = mock(LoggerDecorator.class);
        when(stubLoggerDecorator.decorate(arrayIntMessage)).thenReturn("ArrayIntMessage");

        assertEquals("ArrayIntMessage", arrayIntMessage.getFormattedMessage(stubLoggerDecorator));
    }

    @Test
    public void shouldReturnTheSameMessageWhenCallAccumulate() throws AccumulateException {
        ArrayIntMessage dummyArrayIntMessage = mock(ArrayIntMessage.class);

        assertEquals(dummyArrayIntMessage, arrayIntMessage.accumulate(dummyArrayIntMessage));
    }

}