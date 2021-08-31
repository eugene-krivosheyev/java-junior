package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CharMessageTest{
    boolean contains(Message message, String toContain) {
        return message.toString().contains(toContain);
    }
    @Test
    public void shouldContainPrimitivePrefixWhenCharMessageToString() {
        Message messageSut = new CharMessage('a');
        assertTrue(contains(messageSut,"char: "));
    }
    @Test
    void shouldSameObjectsOfCharMessageBeEqual() {
        CharMessage messageSut = new CharMessage('a');
        CharMessage messageStub = messageSut;

        assertTrue(messageSut.equals(messageStub));
    }

    @Test
    void shouldCharMessagesWithEqualValuesBeEqual() {
        CharMessage messageSut = new CharMessage('a');
        CharMessage messageStub = new CharMessage('a');

        assertTrue(messageSut.equals(messageStub));
    }

    @Test
    void shouldCharMessagesWithDifferentValuesNotBeEqual() {
        CharMessage messageSut = new CharMessage('a');
        CharMessage messageStub = new CharMessage('b');

        assertFalse(messageSut.equals(messageStub));
    }

    @Test
    public void shouldArbitraryNotBeEqualToCharMessage() {
        Message messageSut = new CharMessage('a');
        Message messageStub = mock(Message.class);

        assertFalse(messageSut.equals(messageStub));
    }
}
