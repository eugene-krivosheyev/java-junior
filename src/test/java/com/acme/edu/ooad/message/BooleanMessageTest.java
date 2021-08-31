package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanMessageTest{
    boolean contains(Message message, String toContain) {
        return message.toString().contains(toContain);
    }
    @Test
    public void shouldContainPrimitivePrefixWhenBooleanMessageToString() {
        Message messageSut = new BooleanMessage(true);
        assertTrue(contains(messageSut,"primitive: "));
    }
    @Test
    void shouldSameObjectsOfBooleanMessageBeEqual() {
        Message message1 = new BooleanMessage(true);
        Message messageStub = message1;

        assertTrue(message1.equals(messageStub));
    }

    @Test
    public void shouldBooleanMessagesWithEqualValuesBeEqual() {
        Message message1 = new BooleanMessage(true);
        Message messageStub = new BooleanMessage(true);

        assertTrue(message1.equals(messageStub));
    }

    @Test
    public void shouldBooleanMessagesWithDifferentValuesNotBeEqual() {
        Message message1 = new BooleanMessage(true);
        Message messageStub = new BooleanMessage(false);

        assertFalse(message1.equals(messageStub));
    }

    @Test
    public void shouldStringMessageNotBeEqualToBooleanMessage() {
        Message message1 = new BooleanMessage(true);
        Message messageStub = new StringMessage("string");

        assertFalse(message1.equals(messageStub));
    }
}
