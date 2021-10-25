package com.acme.edu.api;

import com.acme.edu.api.message.CharacterMessage;
import com.acme.edu.api.message.Message;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MessageTest {
    private Message initialMessage;
    private Message secondMessage;

    @Test
    public void testReturnValueMethodAccumulate() {
        initialMessage = new CharacterMessage('a');
        secondMessage = new CharacterMessage('b');

        assertEquals(secondMessage, initialMessage.accumulate(secondMessage));
    }
}
