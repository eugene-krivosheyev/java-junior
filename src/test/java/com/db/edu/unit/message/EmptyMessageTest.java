package com.db.edu.unit.message;

import com.db.edu.State;
import com.db.edu.message.EmptyMessage;
import com.db.edu.message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmptyMessageTest {

    public EmptyMessage message = new EmptyMessage();

    @Test
    public void weCanGetNullWhenTryToGetValueFromEmptyMessage() {
        assertNull(message.getValue());
    }

    @Test
    public void weCanGetNullWhenTryToGetDecoratedStringFromEmptyMessage() {
        assertNull(message.decorated());
    }

    @Test
    public void weCanCheckThatEmptyMessageIsEmpty() {
        assertFalse(message.isNotEmpty());
    }

    @Test
    public void weCanGetStateFromEmptyMessage() {
        assertEquals(State.EMPTY, message.getState());
    }

    @Test
    public void weCanCompareEmptyMessageWithAnyMessage() {
        Message messageMock = mock(Message.class);

        assertTrue(message.isStateNotEquals(messageMock));
    }

    @Test
    public void weCanFlushEmptyMessage() {
        assertFalse(message.flush().isNotEmpty());
    }
}
