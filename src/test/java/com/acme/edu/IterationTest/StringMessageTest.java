package com.acme.edu.IterationTest;

import com.acme.edu.decorator.ClassicDecorator;
import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.StringMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StringMessageTest{
    StringMessage stringMessage = new StringMessage("test");

    @Test
    public void shouldAccumulateGivenSameString() {
        StringMessage stub = mock(StringMessage.class);
        when(stub.getMessage()).thenReturn("test");
        stringMessage.accumulate(stub);
        assertEquals("test", stringMessage.getMessage());
        assertEquals(2, stringMessage.getCounter());
    }

    @Test
    public void shouldAcceptDecoratorGivenStringMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        stringMessage.accept(mock);

        verify(mock).decorateString(anyString(), anyInt());
    }

    @Test
    public void shouldDeclineDifferentTypeWhenSameTypeOfStringMessage(){
        ByteMessage byteMessage = new ByteMessage((byte)0);

        assertTrue(!stringMessage.isSameTypeOf(byteMessage));
    }

    @Test
    public void shouldAcceptSameTypeWhenSameTypeOfStringMessage(){
        StringMessage testStringMessage = new StringMessage("test");

        assertTrue(stringMessage.isSameTypeOf(testStringMessage));
    }

}
