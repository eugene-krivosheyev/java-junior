package com.db.edu.unit.message;

import com.db.edu.State;
import com.db.edu.message.BooleanMessage;
import com.db.edu.message.Message;
import com.db.edu.message.ObjectMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ObjectMessageTest {

    public ObjectMessage message = new ObjectMessage("Hi");

    @Test
    public void weCanGetValueFromNotEmptyObjectMessage() {
        assertEquals("Hi", message.getValue());
    }

    @Test
    public void weCanGetNullFromEmptyObjectMessage() {
        ObjectMessage nullMessage = new ObjectMessage(null);

        assertNull(nullMessage.getValue());
    }

    @Test
    public void weCanGetDecoratedStringFromNotEmptyObjectMessage() {
        assertEquals("reference: Hi", message.decorated());
    }

    @Test
    public void weCanNotChangeAnythingUsingAccumulateWithObjectMessages() {
        assertEquals(message.getValue(), message.accumulate(mock(ObjectMessage.class)).getValue());
    }

    @Test
    public void weCanGetStateFromNotEmptyObjectMessage() {
        assertEquals(State.OBJECT, message.getState());
    }

    @Test
    public void weCanCheckThatObjectMessageIsNotEmpty() {
        assertTrue(message.isNotEmpty());
    }

    @Test
    public void weCanCompareObjectMessageWithAnEmptyMessage() {
        Message messageMock = mock(Message.class);
        when(messageMock.getState()).thenReturn(State.EMPTY);

        assertTrue(message.isStateNotEquals(messageMock));
    }

    @Test
    public void weCanFlushObjectMessage() {
        assertFalse(message.flush().isNotEmpty());
    }
}
