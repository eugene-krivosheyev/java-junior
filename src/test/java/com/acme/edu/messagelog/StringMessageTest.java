package com.acme.edu.messagelog;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringMessageTest {
    private StringMessage stringMessage;

    @Before
    public void setUp() throws Exception {
        stringMessage = new StringMessage("str 1");
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedWithOtherMessageType() {
        ByteMessage dummyStringMessage = mock(ByteMessage.class);

        assertFalse(stringMessage.canBeAccumulated(dummyStringMessage));
    }

    @Test
    public void shouldReturnTrueWhenCallCanBeAccumulatedWithStringMessageWithTheSameValue() {
        StringMessage dummyStringMessage = new StringMessage(stringMessage.getValue());
        assertTrue(stringMessage.canBeAccumulated(dummyStringMessage));
    }

    @Test
    public void shouldReturnDecoratedMessageWhenCallGetFormattedString() {
        LoggerDecorator stubLoggerDecorator = mock(LoggerDecorator.class);
        when(stubLoggerDecorator.decorate(stringMessage))
                .thenAnswer((invocationOnMock) -> "StringMessage: " + stringMessage.getValue());

        assertEquals("StringMessage: " + stringMessage.getValue(), stringMessage.getFormattedMessage(stubLoggerDecorator));
    }

    @Test
    public void shouldReturnNewStringMessageWhenCallAccumulate() {
        StringMessage dummyStringMessage = mock(StringMessage.class);

        assertNotEquals(dummyStringMessage, stringMessage.accumulate(dummyStringMessage));
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedWithDifferentValue(){
        StringMessage newMessage = new StringMessage("str 2");

        assertFalse(stringMessage.canBeAccumulated(newMessage));
    }
}