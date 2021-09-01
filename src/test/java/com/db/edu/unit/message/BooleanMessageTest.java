package com.db.edu.unit.message;

import com.db.edu.State;
import com.db.edu.message.BooleanMessage;
import com.db.edu.message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooleanMessageTest {

    BooleanMessage message = new BooleanMessage(false);

    @Test
    public void weCanGetValueFromNotEmptyBooleanMessage() {
        assertEquals("false", message.getValue());
    }

    @Test
    public void weCanGetNullFromEmptyBooleanMessage() {
        BooleanMessage nullMessage = new BooleanMessage(null);

        assertNull(nullMessage.getValue());
    }

    @Test
    public void weCanGetDecoratedStringFromNotEmptyBooleanMessage() {
        assertEquals("primitive: false", message.decorated());
    }

    @Test
    public void weCanNotChangeAnythingUsingAccumulate() {
        assertEquals(message.getValue(), message.accumulate(mock(BooleanMessage.class)).getValue());
    }

    @Test
    public void weCanGetStateFromNotEmptyBooleanMessage() {
        assertEquals(State.BOOLEAN, message.getState());
    }

    @Test
    public void weCanCheckThatBooleanMessageIsNotEmpty() {
        assertTrue(message.isNotEmpty());
    }

    @Test
    public void weCanCompareBooleanMessageWithAnEmptyMessage() {
        Message messageMock = mock(Message.class);
        when(messageMock.getState()).thenReturn(State.EMPTY);

        assertTrue(message.isStateNotEquals(messageMock));
    }

    @Test
    public void weCanFlushBooleanMessage() {
        assertFalse(message.flush().isNotEmpty());
    }
}
