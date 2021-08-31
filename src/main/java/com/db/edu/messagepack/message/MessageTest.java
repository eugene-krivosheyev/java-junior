package com.db.edu.messagepack.message;

import com.db.edu.messagepack.message.ByteMessage;
import com.db.edu.messagepack.message.CharMessage;
import com.db.edu.messagepack.message.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class MessageTest {
    @Test
    public void shouldCompareCorrectlyWhenTypesAreDifferent() {
        Message sutPreviousIntMessage = new ByteMessage((byte) 5);
        Message stubCharMessage = mock(CharMessage.class);

        Assertions.assertEquals(false, sutPreviousIntMessage.isSameType(stubCharMessage));

    }
    @Test
    public void shouldCompareCorrectlyWhenTypesTheSame() {
        Message sutPreviousCharMessage = new CharMessage('b');
        Message sutCharMessage = new CharMessage('a');

        Assertions.assertEquals(false, sutPreviousCharMessage.isSameType(sutCharMessage));
    }

    @Test
    public void shouldAccumulateCorrectlyWhenTypesAreNonAccumulated() {
        CharMessage sutPreviousCharMessage = new CharMessage('b');
        CharMessage sutCharMessage = new CharMessage('a');

        CharMessage accumulation = (CharMessage)sutPreviousCharMessage.accumulate(sutCharMessage);
        Assertions.assertEquals('a', accumulation.getBody());
    }

}
