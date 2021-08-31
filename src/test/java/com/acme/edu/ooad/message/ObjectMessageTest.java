package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ObjectMessageTest{
    boolean contains(Message message, String toContain) {
        return message.toString().contains(toContain);
    }
    @Test
    public void shouldContainReferencePrefixWhenObjectMessageToString() {
        Message messageSut = new ObjectMessage(new Object());
        assertTrue(contains(messageSut,"reference: "));
    }
    @Test
    void shouldSameObjectsOfObjectMessageBeEqual() {
        ObjectMessage messageSut = new ObjectMessage(new Object());
        ObjectMessage messageStub = messageSut;

        assertTrue(messageSut.equals(messageStub));
    }

    @Test
    void shouldObjectMessagesWithEqualValuesBeEqual() {
        Object object = new Object();
        ObjectMessage messageSut = new ObjectMessage(object);
        ObjectMessage messageStub = new ObjectMessage(object);

        assertTrue(messageSut.equals(messageStub));
    }

    @Test
    void shouldObjectMessagesWithDifferentValuesNotBeEqual() {
        ObjectMessage messageSut = new ObjectMessage(new Object());
        ObjectMessage messageStub = new ObjectMessage(new Object());

        assertFalse(messageSut.equals(messageStub));
    }

    @Test
    public void shouldArbitraryNotBeEqualToObjectMessage() {
        Message messageSut = new ObjectMessage(new Object());
        Message messageStub = mock(Message.class);

        assertFalse(messageSut.equals(messageStub));
    }
    @Test
    public void shouldConvertNullToEmptyStringWhenGetBody() {
        Message message = new ObjectMessage(null);

        assertEquals("", message.getBody());
    }
    @Test
    public void shouldConvertValueToStringWhenGetBody() {
        Object obj = new Object();
        Message message = new ObjectMessage(obj);

        assertEquals(obj.toString(), message.getBody());
    }
    @Test
    public void shouldGetMessageWhenGetNewInstance() {
        Message messageSut = new ObjectMessage(new Object());
        Message messageStub = mock(Message.class);

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
    }
    @Test
    public void shouldGetThisMessageWhenGetInstanceToPrint() {
        Message messageSut = new ObjectMessage(new Object());
        Message messageStub = mock(Message.class);

        assertEquals(messageSut, messageSut.getInstanceToPrint(messageStub));
    }

}
