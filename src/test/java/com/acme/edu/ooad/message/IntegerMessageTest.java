package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class IntegerMessageTest {
    boolean contains(Message message, String toContain) {
        return message.toString().contains(toContain);
    }
    @Test
    public void shouldContainPrimitivePrefixWhenIntegerMessageToString() {
        Message messageSut = new IntegerMessage(0);
        assertTrue(contains(messageSut,"primitive: "));
    }
    @Test
    public void shouldUpdateMessageByNewInstanceWhenAfterIntegerMessageAnotherTypeComes(){
        Message messageSut = new IntegerMessage(1);
        Message messageStub = mock(Message.class);

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
    }
    @Test
    public void shouldAccumulateWhenIntegerMessageComesAgain() {
        IntegerMessage previousMessage = new IntegerMessage(5);
        IntegerMessage newMessage = new IntegerMessage(3);
        assertEquals(5+3, ((IntegerMessage)previousMessage.getNewInstance(newMessage)).value);
    }
    @Test
    void shouldBeNothingToPrintIfIntegerMessageComesAgain() {
        Message previousMessage = new IntegerMessage(2);
        Message newMessage = new IntegerMessage(3);

        assertNull(previousMessage.getInstanceToPrint(newMessage));
    }
    @Test
    public void shouldPrintIntMessageWhenAnotherTypeComes(){
        Message previousMessage = new IntegerMessage(1);
        Message messageOfAnotherType = mock(Message.class);

        assertEquals(previousMessage, previousMessage.getInstanceToPrint(messageOfAnotherType));
    }
    @Test
    void shouldValueBeZeroWhenIntegerMessageIsCleaned() {
        IntegerMessage message = new IntegerMessage(5);
        message.clean();
        assertEquals(0, message.value);
    }
    @Test
    void shouldSameObjectsOfIntegerMessageBeEqual() {
        IntegerMessage messageSut = new IntegerMessage(1);
        IntegerMessage messageStub = messageSut;

        assertTrue(messageSut.equals(messageStub));
    }

    @Test
    void shouldIntegerMessagesWithEqualValuesBeEqual() {
        IntegerMessage messageSut = new IntegerMessage(1);
        IntegerMessage messageStub = new IntegerMessage(1);

        assertTrue(messageSut.equals(messageStub));
    }

    @Test
    void shouldIntegerMessagesWithDifferentValuesNotBeEqual() {
        IntegerMessage messageSut = new IntegerMessage(1);
        IntegerMessage messageStub = new IntegerMessage(2);

        assertFalse(messageSut.equals(messageStub));
    }

    @Test
    public void shouldArbitraryNotBeEqualToIntegerMessage() {
        Message messageSut = new IntegerMessage(1);
        Message messageStub = mock(Message.class);

        assertFalse(messageSut.equals(messageStub));
    }

}
