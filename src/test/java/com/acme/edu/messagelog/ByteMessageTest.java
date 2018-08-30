package com.acme.edu.messagelog;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ByteMessageTest {
    private ByteMessage byteMessage;

    @Before
    public void setUp() throws Exception {
        byteMessage = new ByteMessage((byte)1);
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedWithOtherMessageType() {
        ByteMessage dummyByteMessage = mock(ByteMessage.class);
        assertFalse(byteMessage.canBeAccumulated(dummyByteMessage));
    }

    @Test
    public void shouldReturnTrueWhenCallCanBeAccumulatedWithPositiveByteMessageWithoutOverflow() {
        ByteMessage dummyByteMessage = new ByteMessage((byte)4);
        assertTrue(byteMessage.canBeAccumulated(dummyByteMessage));
    }

    @Test
    public void shouldReturnTrueWhenCallCanBeAccumulatedWithNegativeByteMessageWithoutOverflow() {
        ByteMessage dummyByteMessage = new ByteMessage((byte)-4);
        assertTrue(byteMessage.canBeAccumulated(dummyByteMessage));
    }

    @Test
    public void shouldReturnDecoratedMessageWhenCallGetFormattedString() {
        LoggerDecorator stubLoggerDecorator = mock(LoggerDecorator.class);
        when(stubLoggerDecorator.decorate(byteMessage))
                .thenAnswer((invocationOnMock) -> "ByteMessage: " + byteMessage.getValue());

        assertEquals("ByteMessage: " + byteMessage.getValue(), byteMessage.getFormattedMessage(stubLoggerDecorator));
    }

    @Test
    public void shouldReturnNewByteMessageWhenCallAccumulate() {
        ByteMessage dummyByteMessage = mock(ByteMessage.class);

        assertNotEquals(dummyByteMessage, byteMessage.accumulate(dummyByteMessage));
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedInPositiveOverflowCase(){
        ByteMessage dummyByteMessage = new ByteMessage(Byte.MAX_VALUE);

        assertFalse(byteMessage.canBeAccumulated(dummyByteMessage));
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedInNegativeOverflowCase(){
        ByteMessage byteMessage1 = new ByteMessage(Byte.MIN_VALUE);
        ByteMessage byteMessage2 = new ByteMessage((byte)-1);

        assertFalse(byteMessage1.canBeAccumulated(byteMessage2));
    }
}