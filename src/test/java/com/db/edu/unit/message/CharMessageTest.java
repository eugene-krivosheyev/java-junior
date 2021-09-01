package com.db.edu.unit.message;

import com.db.edu.State;
import com.db.edu.message.CharMessage;
import com.db.edu.message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CharMessageTest {

    CharMessage message = new CharMessage('a');

    @Test
    public void weCanGetValueFromNotEmptyCharMessage() {
        assertEquals("a", message.getValue());
    }

    @Test
    public void weCanGetNullFromEmptyCharMessage() {
        CharMessage nullMessage = new CharMessage(null);

        assertNull(nullMessage.getValue());
    }

    @Test
    public void weCanNotChangeAnythingUsingAccumulate() {
        assertEquals(message.getValue(), message.accumulate(mock(CharMessage.class)).getValue());
    }

    @Test
    public void weCanGetDecoratedStringFromNotEmptyCharMessage() {
        assertEquals("char: a", message.decorated());
    }

    @Test
    public void weCanCheckThatCharMessageIsNotEmpty() {
        assertTrue(message.isNotEmpty());
    }

    @Test
    public void weCanGetStateFromNotEmptyCharMessage() {
        assertEquals(State.CHAR, message.getState());
    }

    @Test
    public void weCanCompareCharMessageWithAnEmptyMessage() {
        Message messageMock = mock(Message.class);
        when(messageMock.getState()).thenReturn(State.EMPTY);

        assertTrue(message.isStateNotEquals(messageMock));
    }

    @Test
    public void weCanFlushCharMessage() {
        assertFalse(message.flush().isNotEmpty());
    }
}
