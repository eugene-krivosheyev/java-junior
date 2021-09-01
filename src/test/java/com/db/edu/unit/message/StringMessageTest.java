package com.db.edu.unit.message;

import com.db.edu.State;
import com.db.edu.message.Message;
import com.db.edu.message.StringMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringMessageTest {

    Message message = new StringMessage("Hello");

    @Test
    public void weCanGetValueFromNotEmptyStringMessage() {
        assertEquals("Hello", message.getValue());
    }

    @Test
    public void weCanGetNullFromEmptyStringMessage() {
        StringMessage nullMessage = new StringMessage(null);

        assertNull(nullMessage.getValue());
    }

    @Test
    public void weCanGetDecoratedStringFromNotEmptyStringMessage() {
        assertEquals("string: Hello", message.decorated());
    }

    @Test
    public void weCanCheckThatStringMessageIsNotEmpty() {
        assertTrue(message.isNotEmpty());
    }

    @Test
    public void weCanGetStateFromNotEmptyStringMessage() {
        assertEquals(State.STRING, message.getState());
    }

    @Test
    public void weCanCompareStringMessageWithEmptyMessage() {
        Message messageMock = mock(Message.class);
        when(messageMock.getState()).thenReturn(State.EMPTY);

        assertTrue(message.isStateNotEquals(messageMock));
    }

    @Test
    public void weCanCompareStringMessageWithAnotherStringMessage() {
        StringMessage messageMock = mock(StringMessage.class);
        when(messageMock.getValue()).thenReturn("Hello");
        when(messageMock.getState()).thenReturn(State.STRING);

        assertTrue(message.isStateEquals(messageMock));
    }

    @Test
    public void weCanAccumulateStringMessage() {
        Message messageMock = mock(Message.class);
        when(messageMock.getValue()).thenReturn("Hello");

        assertEquals("Hello", message.accumulate(messageMock).getValue());
    }

    @Test
    public void weCanAccumulateStringMessageFromStringMessage() {
        Message repetitiveMessage = new StringMessage(message.getValue());
        message = message.accumulate(repetitiveMessage);
        message = message.accumulate(message);

        assertEquals("string: Hello (x2)", message.decorated());
    }

    @Test
    public void weCanFlushStringMessage() {
        assertFalse(message.flush().isNotEmpty());
    }
}
