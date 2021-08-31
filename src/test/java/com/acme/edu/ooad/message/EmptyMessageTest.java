package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class EmptyMessageTest {
    @Test
    public void shouldGetMessageWhenGetNewInstance() {
        Message messageSut = new EmptyMessage();
        Message messageStub = mock(Message.class);

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
    }
    @Test
    public void shouldGetNullWhenGetInstanceToPrint() {
        Message messageSut = new EmptyMessage();
        Message messageStub = mock(Message.class);

        assertNull(messageSut.getInstanceToPrint(messageStub));
    }
    @Test
    public void shouldGetNullWhenGetBody() {
        Message message = new EmptyMessage();

        assertNull(message.getBody());
    }

}
