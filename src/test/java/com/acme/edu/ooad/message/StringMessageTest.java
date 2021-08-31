package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class StringMessageTest{
    boolean contains(Message message, String toContain) {
        return message.toString().contains(toContain);
    }
    @Test
    public void shouldContainStringPrefixWhenStringMessageToString() {
        Message messageSut = new StringMessage("str");
        assertTrue(contains(messageSut,"string: "));
    }
    @Test
    public void shouldContainCounterWhenAccumulatedStringMessageToString() {
        Message messageSut = new StringMessage("str", 3);
        assertTrue(contains(messageSut,"(x3)"));
    }
    @Test
    public void shouldNotContainCounterWhenSingleStringMessageToString() {
        Message messageSut = new StringMessage("str", 1);
        assertFalse(contains(messageSut,"(x1)"));
    }
    @Test
    public void shouldUpdateMessageByNewInstanceWhenAfterStringMessageAnotherTypeComes(){
        Message messageSut = new StringMessage("str");
        Message messageStub = mock(Message.class);

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
    }
    @Test
    public void shouldUpdateMessageByNewInstanceOfStringMessageWhenStringMessageWithAnotherStringComes(){
        Message messageSut = new StringMessage("str1");
        Message messageStub = new StringMessage("str2");

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
    }
    @Test
    public void shouldUpdateStringMessageByInstanceWithIncrementedCounterWhenStringMessageWithSameStringComes(){
        Message previousMessage = new StringMessage("str");
        Message messageWithSameValue = new StringMessage("str");

        assertEquals(new StringMessage("str",2), previousMessage.getNewInstance(messageWithSameValue));
    }
    @Test
    public void shouldAccumulateWhenSameStringMessageComes() {
        Message previousMessage = new StringMessage("string to accumulate");
        Message newMessage = new StringMessage("string to accumulate");
        assertEquals(new StringMessage("string to accumulate",2),
                previousMessage.getNewInstance(newMessage));
    }
    @Test
    void shouldBeNothingToPrintIfSameStringComes() {
        Message previousMessage = new StringMessage("string to accumulate and not to print");
        Message newMessage = new StringMessage("string to accumulate and not to print");

        assertNull(previousMessage.getInstanceToPrint(newMessage));
    }
    @Test
    public void shouldPrintStringMessageWhenAnotherTypeComes(){
        Message previousMessage = new StringMessage("str");
        Message messageOfAnotherType = mock(Message.class);

        assertEquals(previousMessage, previousMessage.getInstanceToPrint(messageOfAnotherType));
    }
    @Test
    void shouldCounterBeZeroWhenStringMessageIsCleaned() {
        StringMessage message = new StringMessage("string to clean", 5);
        message.clean();
        assertEquals(0, message.counter);
    }
    @Test
    void shouldSameStringOfObjectMessageBeEqual() {
        StringMessage messageSut = new StringMessage("string");
        StringMessage messageStub = messageSut;

        assertTrue(messageSut.equals(messageStub));
    }

    @Test
    void shouldStringMessagesWithEqualValuesAndCountersBeEqual() {
        StringMessage messageSut = new StringMessage("string", 2);
        StringMessage messageStub = new StringMessage("string", 2);

        assertTrue(messageSut.equals(messageStub));
    }

    @Test
    void shouldStringMessagesWithDifferentValuesNotBeEqual() {
        StringMessage messageSut = new StringMessage("string 1");
        StringMessage messageStub = new StringMessage("string 2");

        assertFalse(messageSut.equals(messageStub));
    }

    @Test
    void shouldStringMessagesWithDifferentCountersNotBeEqual() {
        StringMessage messageSut = new StringMessage("string", 1);
        StringMessage messageStub = new StringMessage("string", 2);

        assertFalse(messageSut.equals(messageStub));
    }

    @Test
    public void shouldArbitraryNotBeEqualToStringMessage() {
        Message messageSut = new StringMessage("string");
        Message messageStub = mock(Message.class);

        assertFalse(messageSut.equals(messageStub));
    }
    @Test
    public void shouldConvertNullToEmptyStringWhenGetBody() {
        Message message = new StringMessage(null);

        assertEquals("", message.getBody());
    }
    @Test
    public void shouldReturnStringFromStringMessageWhenGetBody() {
        Message message = new StringMessage("string to return");

        assertEquals("string to return", message.getBody());
    }
}
