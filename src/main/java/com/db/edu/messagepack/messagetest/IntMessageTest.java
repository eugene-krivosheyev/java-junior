package com.db.edu.messagepack.messagetest;

import com.db.edu.messagepack.message.Message;
import com.db.edu.messagepack.message.IntMessage;
import com.db.edu.messagepack.message.StringMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntMessageTest {
    @Test
    public void shouldCompareCorrectlyWhenTypesTheSame() {
        Message sutPreviousIntMessage = new IntMessage(5);
        Message sutIntMessage = new IntMessage(13);

        Assertions.assertEquals(true, sutPreviousIntMessage.isSameType(sutIntMessage));
    }

    @Test
    public void shouldCompareCorrectlyWhenTypesAreDifferent() {
        Message sutPreviousIntMessage = new IntMessage(5);
        Message sutStringMessage = new StringMessage("string");

        Assertions.assertEquals(false, sutPreviousIntMessage.isSameType(sutStringMessage));
    }

    @Test
    public void shouldAccumulateCorrectlyWhenTypesTheSame() {
        Message sutPreviousIntMessage = new IntMessage(5);
        Message sutIntMessage = new IntMessage(13);

        Message sum = sutPreviousIntMessage.accumulate(sutIntMessage);
        Assertions.assertEquals("primitive: 18", sum.getDecoratedMessage());
    }
}
