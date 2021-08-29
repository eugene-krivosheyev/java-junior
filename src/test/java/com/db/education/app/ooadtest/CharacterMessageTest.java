package com.db.education.app.ooadtest;

import com.db.education.app.message.CharacterMessage;
import com.db.education.app.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.education.app.ooadtest.PrimitiveMessageTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterMessageTest {

    private String prefix = "char: ";
    private char body = 'A';
    private Message messageOne;

    @BeforeEach
    public void setUp() {
        messageOne = new CharacterMessage(body);
    }

    @Test
    public void shouldDecorateCharacterMessageProperly() {
        runBasicDecorationTest(messageOne, prefix, body);
    }

    @Test
    public void shouldFlushAndNotAccumulateWhenDifferentCharacterMessagesProvided() {
        char body2 = 'B';
        runFlushAndAccumulateTest(messageOne, new CharacterMessage(body2), prefix, body);
    }

    @Test
    public void shouldFlushAndNotAccumulateWhenSameCharacterMessagesProvided() {
        runFlushAndAccumulateTest(messageOne, new CharacterMessage(body), prefix, body);
    }
}
