package com.acme.edu.IterationTest;

import com.acme.edu.decorator.ClassicDecorator;
import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyByte;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public  class ByteMessageTest{
    ByteMessage byteMessage = new ByteMessage((byte)0);


    @Test
    @Ignore
    public void shouldEqualValueGivenAccumulateWithZeroByte() {
        ByteMessage stub = mock(ByteMessage.class);
        when(byteMessage.getMessage()).thenReturn((byte)0);
        byteMessage.accumulate(stub);
        assertEquals((byte) 0, (byte)byteMessage.getMessage());
    }


    @Test
    public void shouldAcceptDecoratorGivenByteMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        byteMessage.accept(mock);

        verify(mock).decorateByte(anyByte());
    }

    @Test
    public void shouldDeclineDifferentTypeWhenSameTypeOfByteMessage(){
        IntMessage testIntMessage = new IntMessage(0);

        assertTrue(!byteMessage.isSameTypeOf(testIntMessage));
    }

    @Test
    public void shouldAcceptSameTypeWhenSameTypeOfByteMessage(){
        ByteMessage testByteMessage = new ByteMessage((byte)0);

        assertTrue(byteMessage.isSameTypeOf(testByteMessage));
    }
}
