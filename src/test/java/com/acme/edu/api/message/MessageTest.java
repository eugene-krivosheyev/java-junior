package com.acme.edu.api.message;

import com.acme.edu.api.message.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
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

    @Test
    public void testTypeEqualsCharacterMessage() {
        initialMessage = new CharacterMessage('a');
        secondMessage = new CharacterMessage('b');

    }

    @Test
    public void testTypeEqualsBooleanMessage() {
        initialMessage = new BooleanMessage(true);
        secondMessage = new BooleanMessage(false);
    }


    @Test
    public void testTypeEqualsIntegerMessage() {
        initialMessage = new IntegerMessage(1);
        secondMessage = new IntegerMessage(2);
    }

    @Test
    public void testTypeEqualsByteMessage() {
        initialMessage = new ByteMessage((byte) 1);
        secondMessage = new ByteMessage((byte) 2);
    }

    @Test
    public void testTypeEqualsObjectRefMessage() {
        initialMessage = new ObjectRefMessage("1");
        secondMessage = new ObjectRefMessage("2");
    }

    @Test
    public void testTypeEqualsPrimitiveArrayMessage() {
        initialMessage = new PrimitiveArrayMessage(new int[0], true);
        secondMessage = new PrimitiveArrayMessage(new int[0], true);
    }

    @Test
    public void testTypeEqualsPrimitiveMatrixMessage() {
        initialMessage = new PrimitiveMatrixMessage(new int[0][0], true);
        secondMessage = new PrimitiveMatrixMessage(new int[0][0], true);
    }


    @AfterEach
    public void testEquals() {
        assertEquals(true, initialMessage.typeEquals(secondMessage));
    }
}
