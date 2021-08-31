package com.acme.edu.ooad.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class MessageTest {
    @Test
    void shouldNotBeSameTypeWhenEvenOneComparedMessageIsNull() {
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

}
