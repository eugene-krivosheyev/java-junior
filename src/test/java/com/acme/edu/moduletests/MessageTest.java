package com.acme.edu.moduletests;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.*;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class MessageTest {
    @Test
    public void shouldAccumulateByte() {
        ByteMessage messageToAccumulate = new ByteMessage((byte)11);
        ByteMessage sut = new ByteMessage((byte)21);

        ByteMessage accumulatedMessage = (ByteMessage) sut.accumulate(messageToAccumulate);

        assertEquals((byte)32, accumulatedMessage.getMessage());
    }

    @Test
    public void byteShouldBeAccumulatableWithByte() {
        ByteMessage messageToAccumulate = new ByteMessage((byte)11);
        FlushMessage notAccumulatableMessage = new FlushMessage();
        ByteMessage sut = new ByteMessage((byte)21);

        assertTrue(sut.isAbleToAccumulate(messageToAccumulate));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
    }

    @Test
    public void byteShouldNotBeAccumulatableWithPositiveOverflow() {
        ByteMessage notAccumulatableMessage = new ByteMessage(Byte.MAX_VALUE);
        ByteMessage sut = new ByteMessage((byte)21);

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
    }

    @Test
    public void byteShouldNotBeAccumulatableWithNegativeOverflow() {
        ByteMessage notAccumulatableMessage = new ByteMessage(Byte.MIN_VALUE);
        ByteMessage sut = new ByteMessage((byte)-21);

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
    }

    @Test
    public void shouldAccumulateInt() {
        IntMessage messageToAccumulate = new IntMessage(11);
        IntMessage sut = new IntMessage(21);

        IntMessage accumulatedMessage = (IntMessage) sut.accumulate(messageToAccumulate);

        assertEquals(32, accumulatedMessage.getMessage());
    }

    @Test
    public void intShouldBeAccumulatableWithInt() {
        IntMessage messageToAccumulate = new IntMessage(11);
        FlushMessage notAccumulatableMessage = new FlushMessage();
        IntMessage sut = new IntMessage(1);

        assertTrue(sut.isAbleToAccumulate(messageToAccumulate));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
    }

    @Test
    public void intShouldNotBeAccumulatableWithPositiveOverflow() {
        IntMessage notAccumulatableMessage = new IntMessage(Integer.MAX_VALUE);
        IntMessage sut = new IntMessage(21);

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
    }

    @Test
    public void intShouldNotBeAccumulatableWithNegativeOverflow() {
        IntMessage notAccumulatableMessage = new IntMessage(Integer.MIN_VALUE);
        IntMessage sut = new IntMessage(-21);

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
    }

    @Test
    public void shouldAccumulateString() {
        String testString = "test string";
        StringMessage messageToAccumulate = new StringMessage(testString);
        StringMessage sut = new StringMessage(testString);

        StringMessage accumulatedMessage = (StringMessage) sut.accumulate(messageToAccumulate);

        assertEquals(testString, accumulatedMessage.getMessage());
        assertEquals(2, accumulatedMessage.getCountOfStrings());
    }

    @Test
    public void stringShouldBeAccumulatableOnlyWithSimilarString() {
        StringMessage sut = new StringMessage("test");
        StringMessage messageToAccumulate = new StringMessage("test");
        FlushMessage notAccumulatableMessage = new FlushMessage();
        StringMessage notAccumulatableStringMessage = new StringMessage("different string");

        assertTrue(sut.isAbleToAccumulate(messageToAccumulate));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableStringMessage));
    }

    @Test
    public void booleanShouldNotBeAccumulatable() {
        BooleanMessage sut = new BooleanMessage(true);
        FlushMessage notAccumulatableMessage = new FlushMessage();
        BooleanMessage notAccumulatableBooleanMessage = new BooleanMessage(true);

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableBooleanMessage));
    }

    @Test
    public void charShouldNotBeAccumulatable() {
        CharMessage sut = new CharMessage('C');
        FlushMessage notAccumulatableMessage = new FlushMessage();
        CharMessage notAccumulatableCharMessage = new CharMessage('C');

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableCharMessage));
    }

    @Test
    public void flushShouldNotBeAccumulatable() {
        FlushMessage sut = new FlushMessage();
        BooleanMessage notAccumulatableMessage = new BooleanMessage(true);
        FlushMessage notAccumulatableFlushMessage = new FlushMessage();

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableFlushMessage));
    }

    @Test
    public void intArrayShouldNotBeAccumulatable() {
        IntArrayMessage sut = new IntArrayMessage(new int[] {1,2,3});
        FlushMessage notAccumulatableMessage = new FlushMessage();
        IntArrayMessage notAccumulatableIntArrayMessage = new IntArrayMessage(new int[] {4,5,6});

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableIntArrayMessage));
    }

    @Test
    public void intMatrixShouldNotBeAccumulatable() {
        IntMatrixMessage sut = new IntMatrixMessage(new int[][] {{1,2},{3,4}});
        FlushMessage notAccumulatableMessage = new FlushMessage();
        IntMatrixMessage notAccumulatableSameTypeMessage = new IntMatrixMessage(new int[][] {{5,6},{7,8}});

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableSameTypeMessage));
    }

    @Test
    public void referenceShouldNotBeAccumulatable() {
        ReferenceMessage sut = new ReferenceMessage(new Object());
        FlushMessage notAccumulatableMessage = new FlushMessage();
        ReferenceMessage notAccumulatableSameTypeMessage = new ReferenceMessage(new Object());

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableSameTypeMessage));
    }

    @Test
    public void BooleanMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new BooleanMessage(true);
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.BOOLEAN);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }

    @Test
    public void ByteMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new ByteMessage((byte)10);
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.BYTE);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }

    @Test
    public void CharMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new CharMessage('A');
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.CHAR);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }

    @Test
    public void FlushMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new FlushMessage();
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.FLUSH);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }

    @Test
    public void IntMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new IntMessage(10);
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.INT);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }

    @Test
    public void IntArrayMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new IntArrayMessage(new int[] {1,2,3});
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.INTARRAY);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }

    @Test
    public void IntMatrixMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new IntMatrixMessage(new int[][] {{1,2},{3,4}});
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.INTMATRIX);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }

    @Test
    public void ReferenceMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new ReferenceMessage(new Object());
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.REFERENCE);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }

    @Test
    public void StringMessageShouldCallDecoratorsDecorateFunction() {
        Map<MessageType, Decorator> mockDecoratorMap = mock(Map.class);
        Decorator mockDecorator = mock(Decorator.class);
        when(mockDecoratorMap.get(any(MessageType.class))).thenReturn(mockDecorator);
        when(mockDecorator.decorate(any(Message.class))).thenReturn("test string");

        Message sut = new StringMessage("test");
        sut.decorate(mockDecoratorMap);

        verify(mockDecoratorMap, times(1)).get(MessageType.STRING);
        verify(mockDecorator, times(1)).decorate(any(Message.class));
    }
}
