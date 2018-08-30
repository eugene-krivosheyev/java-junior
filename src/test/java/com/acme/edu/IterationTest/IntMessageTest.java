package com.acme.edu.IterationTest;

import com.acme.edu.decorator.ClassicDecorator;
import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public  class  IntMessageTest{
    IntMessage intMessage = new IntMessage(0);

    @Test
    public void shouldEqualValueGivenAccumulateWithZeroInt() {
        IntMessage stub = mock(IntMessage.class);
        when(stub.getMessage()).thenReturn(0);
        intMessage.accumulate(stub);
        assertEquals(0, intMessage.getMessage());
    }

    @Test
    public void shouldAcceptDecoratorGivenIntMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        intMessage.accept(mock);

        verify(mock).decorateInt(anyInt());
    }

    @Test
    public void shouldDeclineDifferentTypeInIsSameTypeOfIntMessage(){
        ByteMessage byteMessage = new ByteMessage((byte)0);

        assertTrue(!intMessage.isSameTypeOf(byteMessage));
    }

    @Test
    public void shouldAcceptSameTypeInIsSameTypeOfIntMessage(){
        IntMessage testIntMessage = new IntMessage(0);

        assertTrue(intMessage.isSameTypeOf(testIntMessage));
    }
}
