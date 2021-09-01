package com.db.edu.messagepack.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MessageTest {
    @Test
    public void shouldCompareCorrectlyWhenTypesAreDifferent() {
        Message sutPreviousIntMessage = new ByteMessage((byte) 5);
        Message stubCharMessage = mock(CharMessage.class);

        assertEquals(false, sutPreviousIntMessage.isSameType(stubCharMessage));

    }
    @Test
    public void shouldCompareCorrectlyWhenTypesTheSame() {
        Message sutPreviousCharMessage = new CharMessage('b');
        Message sutCharMessage = new CharMessage('a');

        assertEquals(false, sutPreviousCharMessage.isSameType(sutCharMessage));
    }

    @Test
    public void shouldAccumulateCorrectlyWhenTypesAreNonAccumulated() {
        CharMessage sutPreviousCharMessage = new CharMessage('b');
        CharMessage sutCharMessage = new CharMessage('a');

        CharMessage accumulation = (CharMessage)sutPreviousCharMessage.accumulate(sutCharMessage);
        assertEquals('a', accumulation.getBody());
    }

}
