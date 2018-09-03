package com.acme.edu.messagelog;

import com.acme.edu.loggerexceptions.OverflowAccumulationException;
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
    public void shouldReturnNewByteMessageWhenCallAccumulate() throws OverflowAccumulationException {
        ByteMessage byteMessage1 = new ByteMessage((byte) 2);

        assertNotEquals(byteMessage1, byteMessage.accumulate(byteMessage1));
    }

    @Test(expected = OverflowAccumulationException.class)
    public void shouldThrowExceptionWhenCallAccumulateInPositiveOverflowCase() throws OverflowAccumulationException {
        ByteMessage dummyByteMessage = new ByteMessage(Byte.MAX_VALUE);

        byteMessage.accumulate(dummyByteMessage);
    }

    @Test(expected = OverflowAccumulationException.class)
    public void shouldThrowExceptionWhenCallAccumulateInNegativeOverflowCase() throws OverflowAccumulationException {
        ByteMessage byteMessage1 = new ByteMessage(Byte.MIN_VALUE);
        ByteMessage byteMessage2 = new ByteMessage((byte)-1);

        byteMessage1.accumulate(byteMessage2);
    }
}