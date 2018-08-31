package com.acme.edu.messagelog;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntMessageTest {
    private IntMessage intMessage;

    @Before
    public void setUp() throws Exception {
        intMessage = new IntMessage(1);
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedWithOtherMessageType() {
        ByteMessage dummyByteMessage = mock(ByteMessage.class);

        assertFalse(intMessage.canBeAccumulated(dummyByteMessage));
    }

    @Test
    public void shouldReturnTrueWhenCallCanBeAccumulatedWithPositiveIntMessageWithoutOverflow() {
        IntMessage dummyIntMessage = new IntMessage(4);
        assertTrue(intMessage.canBeAccumulated(dummyIntMessage));
    }

    @Test
    public void shouldReturnTrueWhenCallCanBeAccumulatedWithNegativeIntMessageWithoutOverflow() {
        IntMessage dummyIntMessage = new IntMessage(-4);
        assertTrue(intMessage.canBeAccumulated(dummyIntMessage));
    }

    @Test
    public void shouldReturnDecoratedMessageWhenCallGetFormattedString() {
        LoggerDecorator stubLoggerDecorator = mock(LoggerDecorator.class);
        when(stubLoggerDecorator.decorate(intMessage))
                .thenAnswer((invocationOnMock) -> "IntMessage: " + intMessage.getValue());

        assertEquals("IntMessage: " + intMessage.getValue(), intMessage.getFormattedMessage(stubLoggerDecorator));
    }

    @Test
    public void shouldReturnNewIntMessageWhenCallAccumulate() {
        IntMessage intMessage1 = new IntMessage(5);

        assertNotEquals(intMessage1, intMessage.accumulate(intMessage1));
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedInPositiveOverflowCase(){
        IntMessage dummyIntMessage = new IntMessage(Integer.MAX_VALUE);

        assertFalse(intMessage.canBeAccumulated(dummyIntMessage));
    }

    @Test
    public void shouldReturnFalseWhenCallCanBeAccumulatedInNegativeOverflowCase(){
        IntMessage intMessage1 = new IntMessage(Integer.MIN_VALUE);
        IntMessage intMessage2 = new IntMessage(-1);

        assertFalse(intMessage1.canBeAccumulated(intMessage2));
    }
}