package com.db.edu.messagepack.messagetest;

import com.db.edu.messagepack.message.IntMessage;
import com.db.edu.messagepack.message.Message;
import com.db.edu.messagepack.message.StringMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringMessageTest {
    @Test
    public void shouldCompareCorrectlyWhenTypesAndMessagesTheSame() {
        Message sutPreviousStringMessage = new StringMessage("first string");
        Message sutStringMessage = new StringMessage("first string");

        Assertions.assertEquals(true, sutPreviousStringMessage.isSameType(sutStringMessage));
    }

    @Test
    public void shouldCompareCorrectlyWhenTypesTheSameAndMessagesAreDifferent() {
        Message sutPreviousStringMessage = new StringMessage("first string");
        Message sutStringMessage = new StringMessage("second string");

        Assertions.assertEquals(false, sutPreviousStringMessage.isSameType(sutStringMessage));
    }

    @Test
    public void shouldCompareCorrectlyWhenTypesAreDifferent() {
        Message sutPreviousStringMessage = new StringMessage("first string");
        Message sutIntMessage = new IntMessage(14);

        Assertions.assertEquals(false, sutPreviousStringMessage.isSameType(sutIntMessage));
    }

    @Test
    public void shouldAccumulateCorrectlyWhenTypesAndMessagesTheSame() {
        Message sutPreviousStringMessage = new StringMessage("first string");
        Message sutStringMessage = new StringMessage("first string");

        Message accumulatedStrings = sutPreviousStringMessage.accumulate(sutStringMessage);
        Assertions.assertEquals("string: first string (x2)", accumulatedStrings.getDecoratedMessage());
    }
}
