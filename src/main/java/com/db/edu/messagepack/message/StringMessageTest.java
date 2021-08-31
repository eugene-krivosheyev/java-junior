package com.db.edu.messagepack.message;
import org.mockito.Mock;

import com.db.edu.messagepack.message.IntMessage;
import com.db.edu.messagepack.message.Message;
import com.db.edu.messagepack.message.StringMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class StringMessageTest {
    @Test
    public void shouldCompareCorrectlyWhenTypesAndMessagesTheSame() {
        Message sutPreviousStringMessage = new StringMessage("first string");
        Message sutStringMessage = new StringMessage("first string");

        assertEquals(true, sutPreviousStringMessage.isSameType(sutStringMessage));
    }

    @Test
    public void shouldCompareCorrectlyWhenTypesTheSameAndMessagesAreDifferent() {
        Message sutPreviousStringMessage = new StringMessage("first string");
        Message sutStringMessage = new StringMessage("second string");

        assertEquals(false, sutPreviousStringMessage.isSameType(sutStringMessage));
    }

    @Test
    public void shouldCompareCorrectlyWhenTypesAreDifferent() {
        Message sutPreviousStringMessage = new StringMessage("first string");
        Message stubIntMessage = mock(IntMessage.class);

        assertEquals(false, sutPreviousStringMessage.isSameType(stubIntMessage));
    }

    @Test
    public void shouldNotChangesBodyWhenTypesAndMessagesTheSame() {
        StringMessage sutPreviousStringMessage = new StringMessage("first string");
        StringMessage sutStringMessage = new StringMessage("first string");

        StringMessage accumulatedStrings = sutPreviousStringMessage.accumulate(sutStringMessage);
        assertEquals("first string", accumulatedStrings.getBody());
    }

    @Test
    public void shouldCorrectlySaveNumberOfMessagesWhenTypesAndMessagesTheSame() {
        StringMessage sutPreviousStringMessage = new StringMessage("first string");
        StringMessage sutStringMessage = new StringMessage("first string");

        StringMessage accumulatedStrings = sutPreviousStringMessage.accumulate(sutStringMessage);
        assertEquals(2, accumulatedStrings.getStringCounter());
    }
}
