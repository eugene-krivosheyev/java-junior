package com.db.edu.messagepack.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntMessageTest {
    @Test
    public void shouldCompareCorrectlyWhenTypesTheSame() {
        Message sutPreviousIntMessage = new IntMessage(5);
        Message sutIntMessage = new IntMessage(13);

        assertEquals(true, sutPreviousIntMessage.isSameType(sutIntMessage));
    }

    @Test
    public void shouldCompareCorrectlyWhenTypesAreDifferent() {
        Message sutPreviousIntMessage = new IntMessage(5);
        Message sutStringMessage = new StringMessage("string");

        assertEquals(false, sutPreviousIntMessage.isSameType(sutStringMessage));
    }

    @Test
    public void shouldAccumulateCorrectlyWhenTypesTheSame() {
        IntMessage sutPreviousIntMessage = new IntMessage(5);
        IntMessage sutIntMessage = new IntMessage(13);

        IntMessage sum = sutPreviousIntMessage.accumulate(sutIntMessage);
        assertEquals(18, sum.getBody());
    }
}
