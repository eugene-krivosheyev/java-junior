package com.db.edu.unit.message;

import com.db.edu.State;
import com.db.edu.message.BooleanMessage;
import com.db.edu.message.IntMessage;
import com.db.edu.message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntMessageTest {

    IntMessage message = new IntMessage(1);

    @Test
    public void weCanGetValueFromNotEmptyIntMessage() {
        assertEquals("1", message.getValue());
    }

    @Test
    public void weCanGetNullFromEmptyIntMessage() {
        IntMessage nullMessage = new IntMessage(null);

        assertNull(nullMessage.getValue());
    }

    @Test
    public void weCanGetDecoratedStringFromNotEmptyIntMessage() {
        assertEquals("primitive: 1", message.decorated());
    }

    @Test
    public void weCanCheckThatMessageIsNotEmpty() {
        assertTrue(message.isNotEmpty());
    }

    @Test
    public void weCanGetStateFromNotEmptyIntMessage() {
        assertEquals(State.INT, message.getState());
    }

    @Test
    public void weCanCompareIntMessageWithAnotherMessage() {
        Message messageMock = mock(Message.class);
        when(messageMock.getState()).thenReturn(State.EMPTY);

        assertTrue(message.isStateNotEquals(messageMock));
    }

    @Test
    public void weCanCompareIntMessageWithAnotherIntMessage() {
        IntMessage messageMock = mock(IntMessage.class);
        when(messageMock.getState()).thenReturn(State.INT);

        assertTrue(message.isStateEquals(messageMock));
    }

    @Test
    public void weCanAccumulateIntMessage() {
        IntMessage messageMock = mock(IntMessage.class);
        when(messageMock.getValue()).thenReturn("10");

        assertEquals("11", message.accumulate(messageMock).getValue());
    }

    @Test
    public void weCanFlushIntMessage() {
        assertFalse(message.flush().isNotEmpty());
    }
}
