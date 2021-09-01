package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CharMessageTest {
    private boolean contains(Message message, String toContain) {
        return message.toString().contains(toContain);
    }

    @Test
    public void shouldContainPrimitivePrefixWhenCharMessageToString() {
        Message messageSut = new CharMessage('a');
        assertTrue(contains(messageSut, "char: "));
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

    @Test
    public void shouldConvertValueToStringWhenGetBody() {
        Message message = new CharMessage('a');

        assertEquals("a", message.getBody());
    }

    @Test
    public void shouldGetMessageWhenGetNewInstance() {
        Message messageSut = new CharMessage('a');
        Message messageStub = mock(Message.class);

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
    }

    @Test
    public void shouldGetThisMessageWhenGetInstanceToPrint() {
        Message messageSut = new CharMessage('a');
        Message messageStub = mock(Message.class);

        assertEquals(messageSut, messageSut.getInstanceToPrint(messageStub));
    }
}
