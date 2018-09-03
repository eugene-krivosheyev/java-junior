package com.acme.edu.messagelog;

import com.acme.edu.loggerexceptions.OverflowAccumulationException;
import org.junit.Before;
import org.junit.Test;

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
    public void shouldReturnNewIntMessageWhenCallAccumulate() throws OverflowAccumulationException {
        IntMessage intMessage1 = new IntMessage(5);

        assertNotEquals(intMessage1, intMessage.accumulate(intMessage1));
    }

    @Test(expected = OverflowAccumulationException.class)
    public void shouldThrowExceptionWhenCallAccumulateInPositiveOverflowCase() throws OverflowAccumulationException {
        IntMessage dummyIntMessage = new IntMessage(Integer.MAX_VALUE);

        intMessage.accumulate(dummyIntMessage);
    }

    @Test(expected = OverflowAccumulationException.class)
    public void shouldThrowExceptionWhenCallAccumulateInNegativeOverflowCase() throws OverflowAccumulationException {
        IntMessage intMessage1 = new IntMessage(Integer.MIN_VALUE);
        IntMessage intMessage2 = new IntMessage(-1);

        intMessage1.accumulate(intMessage2);
    }
}