package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ByteMessageTest{
    boolean contains(Message message, String toContain) {
        return message.toString().contains(toContain);
    }
    @Test
    public void shouldContainPrimitivePrefixWhenByteMessageToString() {
        Message messageSut = new ByteMessage((byte)1);

        assertTrue(contains(messageSut,"primitive: "));
    }
    @Test
    public void shouldUpdateMessageByNewInstanceWhenAfterByteMessageAnotherTypeComes(){
        Message messageSut = new ByteMessage((byte)1);
        Message messageStub = mock(Message.class);

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
    }
    @Test
    public void shouldAccumulateWhenByteMessageComesAgain() {
        ByteMessage previousMessage = new ByteMessage((byte)5);
        ByteMessage newMessage = new ByteMessage((byte)3);
        assertEquals(5+3, ((ByteMessage)previousMessage.getNewInstance(newMessage)).value);
    }
    @Test
    void shouldBeNothingToPrintIfByteMessageComesAgain() {
        Message previousMessage = new ByteMessage((byte)2);
        Message newMessage = new ByteMessage((byte)3);

        assertNull(previousMessage.getInstanceToPrint(newMessage));
    }
    @Test
    public void shouldPrintByteMessageWhenAnotherTypeComes(){
        Message messageSut = new ByteMessage((byte)1);
        Message messageStub = mock(Message.class);

        assertEquals(messageSut, messageSut.getInstanceToPrint(messageStub));
    }
    @Test
    void shouldValueBeZeroWhenByteMessageIsCleaned() {
        ByteMessage message = new ByteMessage((byte)5);
        message.clean();
        assertEquals(0, message.value);
    }
    @Test
    void shouldSameObjectsOfByteMessageBeEqual() {
        ByteMessage message1 = new ByteMessage((byte)5);
        ByteMessage messageStub = message1;

        assertTrue(message1.equals(messageStub));
    }

    @Test
    void shouldByteMessagesWithEqualValuesBeEqual() {
        ByteMessage message1 = new ByteMessage((byte)5);
        ByteMessage messageStub = new ByteMessage((byte)5);

        assertTrue(message1.equals(messageStub));
    }

    @Test
    void shouldByteMessagesWithDifferentValuesNotBeEqual() {
        ByteMessage message1 = new ByteMessage((byte)5);
        ByteMessage messageStub = new ByteMessage((byte)3);

        assertFalse(message1.equals(messageStub));
    }

    @Test
    public void shouldArbitraryMessageNotBeEqualToByteMessage() {
        Message messageSut = new ByteMessage((byte)5);
        Message messageStub = mock(Message.class);

        assertFalse(messageSut.equals(messageStub));
    }

}
