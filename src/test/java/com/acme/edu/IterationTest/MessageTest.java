package com.acme.edu.IterationTest;

import com.acme.edu.decorator.ClassicDecorator;
import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.*;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MessageTest {
    IntMessage intMessage = new IntMessage(0);
    ByteMessage byteMessage = new ByteMessage((byte)0);
    StringMessage stringMessage = new StringMessage("test");
    BooleanMessage booleanMessage = new BooleanMessage(false);
    CharMessage charMessage = new CharMessage((char)32);
    ObjectMessage objectMessage = new ObjectMessage(new Object());
    int[] firstRow = new int[] {1, 2, 3};
    int[] secondRow = new int[] {2, 3, 4};
    IntArrayMessage intArrayMessage = new IntArrayMessage(firstRow);
    IntMatrixMessage intMatrixMessage = new IntMatrixMessage(new int[][] {firstRow, secondRow});

    @Test
    public void shouldEqualValueGivenAccumulateWithZeroInt() {
        IntMessage stub = mock(IntMessage.class);
        when(stub.getMessage()).thenReturn(0);
        intMessage.accumulate(stub);
        assertEquals(0, intMessage.getMessage());
    }

    @Test
    @Ignore
    public void shouldEqualValueGivenAccumulateWithZeroByte() {
        ByteMessage stub = mock(ByteMessage.class);
        when(byteMessage.getMessage()).thenReturn((byte)0);
        byteMessage.accumulate(stub);
        assertEquals((byte) 0, (byte)byteMessage.getMessage());
    }

    @Test
    public void shouldAccumulateGivenSameString() {
        StringMessage stub = mock(StringMessage.class);
        when(stub.getMessage()).thenReturn("test");
        stringMessage.accumulate(stub);
        assertEquals("test", stringMessage.getMessage());
        assertEquals(2, stringMessage.getCounter());
    }

    @Test
    public void shouldAcceptDecoratorGivenIntMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        intMessage.accept(mock);

        verify(mock).decorateInt(anyInt());
    }

    @Test
    public void shouldAcceptDecoratorGivenByteMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        byteMessage.accept(mock);

        verify(mock).decorateByte(anyByte());
    }

    @Test
    public void shouldAcceptDecoratorGivenBooleanMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        booleanMessage.accept(mock);

        verify(mock).decorateBoolean(anyBoolean());
    }

    @Test
    public void shouldAcceptDecoratorGivenCharMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        charMessage.accept(mock);

        verify(mock).decorateChar(anyChar());
    }

    @Test
    public void shouldAcceptDecoratorGivenStringMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        stringMessage.accept(mock);

        verify(mock).decorateString(anyString(), anyInt());
    }

    @Test
    public void shouldAcceptDecoratorGivenIntArrayMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        intArrayMessage.accept(mock);

        verify(mock).decorateIntArray(any());
    }

    @Test
    public void shouldAcceptDecoratorGivenIntMatrixMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        intMatrixMessage.accept(mock);

        verify(mock).decorateIntMatrix(any());
    }
}
