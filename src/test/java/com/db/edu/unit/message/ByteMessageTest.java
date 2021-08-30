package com.db.edu.unit.message;

import com.db.edu.State;
import com.db.edu.message.BooleanMessage;
import com.db.edu.message.ByteMessage;
import com.db.edu.message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ByteMessageTest {

    public ByteMessage message = new ByteMessage((byte)1);

    @Test
    public void weCanGetValueFromNotEmptyByteMessage() {
        assertEquals("1", message.getValue());
    }

    @Test
    public void weCanGetNullFromEmptyByteMessage() {
        ByteMessage nullMessage = new ByteMessage(null);

        assertNull(nullMessage.getValue());
    }

    @Test
    public void weCanGetDecoratedStringFromNotEmptyByteMessage() {
        assertEquals("primitive: 1", message.decorated());
    }

    @Test
    public void weCanCheckThatByteMessageIsNotEmpty() {
        assertTrue(message.isNotEmpty());
    }

    @Test
    public void weCanGetStateFromNotEmptyByteMessage() {
        assertEquals(State.BYTE, message.getState());
    }

    @Test
    public void weCanCompareByteMessageWithAnEmptyMessage() {
        Message messageMock = mock(Message.class);
        when(messageMock.getState()).thenReturn(State.EMPTY);

        assertTrue(message.isStateNotEquals(messageMock));
    }

    @Test
    public void weCanFlushByteMessage() {
        assertFalse(message.flush().isNotEmpty());
    }
}
