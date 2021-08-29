package com.db.education.app.ooadtest;

import com.db.education.app.message.EmptyMessage;
import com.db.education.app.message.IntegerMessage;
import com.db.education.app.message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyMessageTest {

    @Test
    public void shouldReturnReceivedMessageWhenAccumulateInvoked() {
        EmptyMessage emptyMessage = new EmptyMessage();
        IntegerMessage integerMessage = new IntegerMessage(1000);
        Message expectedMessage = integerMessage;
        String expectedMessageString = integerMessage.toString();

        Message actualMessage = emptyMessage.accumulate(integerMessage);
        String actualMessageString = actualMessage.toString();

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedMessageString, actualMessageString);
    }

    @Test
    public void shouldDecorateEmptyMessageNotLikeOtherMessages() {
        EmptyMessage emptyMessage = new EmptyMessage();
        String expectedMessageString = "EMPTY MESSAGE";

        String actualMessageString = emptyMessage.toString();

        assertEquals(expectedMessageString, actualMessageString);
    }
}
