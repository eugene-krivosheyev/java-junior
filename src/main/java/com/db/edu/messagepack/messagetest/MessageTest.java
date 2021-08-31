package com.db.edu.messagepack.messagetest;

import com.db.edu.messagepack.message.ByteMessage;
import com.db.edu.messagepack.message.CharMessage;
import com.db.edu.messagepack.message.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageTest {
    @Test
    public void shouldCompareCorrectlyWhenTypesTheSame() {
        Message sutPreviousIntMessage = new ByteMessage((byte) 5);
        Message sutIntMessage = new CharMessage('a');

        Assertions.assertEquals(false, sutPreviousIntMessage.isSameType(sutIntMessage));

    }
    @Test
    public void shouldCompareCorrectlyWhenTypesAreDifferent() {
        Message sutPreviousIntMessage = new CharMessage('b');
        Message sutIntMessage = new CharMessage('a');

        Assertions.assertEquals(false, sutPreviousIntMessage.isSameType(sutIntMessage));
    }
}
