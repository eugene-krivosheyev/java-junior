package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class MessageTest {
    boolean contains(Message message, String toContain) {
        return message.toString().contains(toContain);
    }

    @Test
    public void shouldContainPrimitivePrefixWhenBooleanMessageToString() {
        Message messageSut = new BooleanMessage(true);
        assertTrue(contains(messageSut,"primitive: "));
    }

    @Test
    public void shouldContainPrimitivePrefixWhenByteMessageToString() {
        Message messageSut = new ByteMessage((byte)1);

        assertTrue(contains(messageSut,"primitive: "));
    }

    @Test
    public void shouldContainPrimitivePrefixWhenCharMessageToString() {
        Message messageSut = new CharMessage('a');
        assertTrue(contains(messageSut,"char: "));
    }

    @Test
    public void shouldContainPrimitivePrefixWhenIntegerMessageToString() {
        Message messageSut = new IntegerMessage(0);
        assertTrue(contains(messageSut,"primitive: "));
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
    public void shouldContainReferencePrefixWhenObjectMessageToString() {
        Message messageSut = new ObjectMessage(new Object());
        assertTrue(contains(messageSut,"reference: "));
    }

    @Test
    public void shouldNotBeSameTypeWhenEvenOneComparedMessageIsNull() {
        Message notNullMessageStub = mock(Message.class);
        Message nullMessageSut = null;

        boolean firstIsNull = Message.sameType(nullMessageSut,notNullMessageStub);
        boolean secondIsNull = Message.sameType(notNullMessageStub, nullMessageSut);

        assertFalse(firstIsNull);
        assertFalse(secondIsNull);
    }

    @Test
    public void shouldNotBeSameTypeWhenCompareIntegerMessageAndByteMessage() {
        Message intMessage = mock(IntegerMessage.class);
        Message byteMessage = mock(ByteMessage.class);

        boolean areByteAndIntSame = Message.sameType(byteMessage,intMessage) ||
                                    Message.sameType(intMessage,byteMessage);

        assertFalse(areByteAndIntSame);
    }
    
    @Test
    public void shouldNotBeSameTypeWhenCompareIntegerMessageAndStringMessage() {
        Message strMessage = mock(StringMessage.class);
        Message intMessage = mock(IntegerMessage.class);

        boolean areIntAndStrSame = Message.sameType(intMessage,strMessage) ||
                                   Message.sameType(strMessage,intMessage) ;

        assertFalse(areIntAndStrSame);
    }
    
    @Test
    public void shouldNotBeSameTypeWhenCompareByteMessageAndStringMessage() {
        Message strMessage = mock(StringMessage.class);
        Message byteMessage = mock(ByteMessage.class);

        boolean areByteAndStrSame = Message.sameType(byteMessage,strMessage) ||
                                    Message.sameType(strMessage,byteMessage) ;

        assertFalse(areByteAndStrSame);
    }
    
    @Test
    public void shouldUpdateMessageByNewInstanceWhenAfterByteMessageAnotherTypeComes(){
        Message messageSut = new ByteMessage((byte)1);
        Message messageStub = mock(Message.class);

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
    }
    
    @Test
    public void shouldUpdateMessageByNewInstanceWhenAfterIntegerMessageAnotherTypeComes(){
        Message messageSut = new IntegerMessage(1);
        Message messageStub = mock(Message.class);

        assertEquals(messageStub, messageSut.getNewInstance(messageStub));
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
    public void shouldAccumulateWhenByteMessageComesAgain() {
        ByteMessage previousMessage = new ByteMessage((byte)5);
        ByteMessage newMessage = new ByteMessage((byte)3);
        assertEquals(5+3, ((ByteMessage)previousMessage.getNewInstance(newMessage)).value);
    }

    @Test
    public void shouldAccumulateWhenIntegerMessageComesAgain() {
        IntegerMessage previousMessage = new IntegerMessage(5);
        IntegerMessage newMessage = new IntegerMessage(3);
        assertEquals(5+3, ((IntegerMessage)previousMessage.getNewInstance(newMessage)).value);
    }

    @Test
    public void shouldAccumulateWhenSameStringMessageComes() {
        Message previousMessage = new StringMessage("string to accumulate");
        Message newMessage = new StringMessage("string to accumulate");
        assertEquals(new StringMessage("string to accumulate",2),
                previousMessage.getNewInstance(newMessage));
    }

    @Test
    void shouldBeNothingToPrintIfByteMessageComesAgain() {
        Message previousMessage = new ByteMessage((byte)2);
        Message newMessage = new ByteMessage((byte)3);

        assertNull(previousMessage.getInstanceToPrint(newMessage));
    }

    @Test
    void shouldBeNothingToPrintIfIntegerMessageComesAgain() {
        Message previousMessage = new IntegerMessage(2);
        Message newMessage = new IntegerMessage(3);

        assertNull(previousMessage.getInstanceToPrint(newMessage));
    }

    @Test
    void shouldBeNothingToPrintIfSameStringComes() {
        Message previousMessage = new StringMessage("string to accumulate and not to print");
        Message newMessage = new StringMessage("string to accumulate and not to print");

        assertNull(previousMessage.getInstanceToPrint(newMessage));
    }

    @Test
    public void shouldPrintByteMessageWhenAnotherTypeComes(){
        Message messageSut = new ByteMessage((byte)1);
        Message messageStub = mock(Message.class);

        assertEquals(messageSut, messageSut.getInstanceToPrint(messageStub));
    }

    @Test
    public void shouldPrintIntMessageWhenAnotherTypeComes(){
        Message previousMessage = new IntegerMessage(1);
        Message messageOfAnotherType = mock(Message.class);

        assertEquals(previousMessage, previousMessage.getInstanceToPrint(messageOfAnotherType));
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
    void shouldValueBeZeroWhenByteMessageIsCleaned() {
        ByteMessage message = new ByteMessage((byte)5);
        message.clean();
        assertEquals(0, message.value);
    }

    @Test
    void shouldValueBeZeroWhenIntegerMessageIsCleaned() {
        IntegerMessage message = new IntegerMessage(5);
        message.clean();
        assertEquals(0, message.value);
    }

    /**
     *     BooleanMessage equals() tests
     */
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

    /**
     *     ByteMessage equals() tests
     */
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

    /**
     *     CharMessage equals() tests
     */
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

    /**
     *     IntegerMessage equals() tests
     */
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

    /**
     *     ObjectMessage equals() tests
     */
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

    /**
     *     StringMessage equals() tests
     */
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
}
