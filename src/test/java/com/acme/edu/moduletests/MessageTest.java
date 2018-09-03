package com.acme.edu.moduletests;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.*;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class MessageTest {
    @Test
    public void booleanShouldReturnMessage() {
        Boolean test = true;
        BooleanMessage sut = new BooleanMessage(test);

        assertEquals(test, sut.getMessage());
    }

    @Test
    public void byteShouldReturnMessage() {
        byte test = (byte) 41;
        ByteMessage sut = new ByteMessage(test);

        assertEquals(test, sut.getMessage());
    }

    @Test
    public void charShouldReturnMessage() {
        char test = 'd';
        CharMessage sut = new CharMessage(test);

        assertEquals(test, sut.getMessage());
    }

    @Test
    public void intShouldReturnMessage() {
        int test = 111;
        IntMessage sut = new IntMessage(test);

        assertEquals(test, sut.getMessage());
    }

    @Test
    public void intArrayShouldReturnMessage() {
        int[] test = {1,2,3};
        IntArrayMessage sut = new IntArrayMessage(test);

        assertArrayEquals(test, sut.getMessage());
    }

    @Test
    public void intMatrixShouldReturnMessage() {
        int[][] test = {{1,2},{3,4}};
        IntMatrixMessage sut = new IntMatrixMessage(test);

        assertArrayEquals(test, sut.getMessage());
    }

    @Test
    public void referenceShouldReturnMessage() {
        ReferenceMessage sut = new ReferenceMessage(new Object());

        assertTrue(sut.getMessage() instanceof Object);
    }

    @Test
    public void stringShouldReturnMessage() {
        String test = "test";
        StringMessage sut = new StringMessage(test);

        assertEquals(test, sut.getMessage());
    }

    @Test
    public void shouldAccumulateByte() {
        ByteMessage messageToAccumulate = new ByteMessage((byte)11);
        ByteMessage negativeMessageToAccumulate = new ByteMessage((byte)-1);
        ByteMessage sut = new ByteMessage((byte)21);

        ByteMessage accumulatedMessage = (ByteMessage) sut.accumulate(messageToAccumulate);
        assertEquals((byte)32, accumulatedMessage.getMessage());

        accumulatedMessage = (ByteMessage) sut.accumulate(negativeMessageToAccumulate);
        assertEquals((byte)20, accumulatedMessage.getMessage());
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
        IntMessage negativeMessageToAccumulate = new IntMessage(-1);
        IntMessage sut = new IntMessage(21);

        IntMessage accumulatedMessage = (IntMessage) sut.accumulate(messageToAccumulate);
        assertEquals(32, accumulatedMessage.getMessage());

        accumulatedMessage = (IntMessage) sut.accumulate(negativeMessageToAccumulate);
        assertEquals(20, accumulatedMessage.getMessage());
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
    public void intAccumulationWithCollectionsAndStreamApi() {
        IntMessage message1 = new IntMessage(Integer.MAX_VALUE-3);
        IntMessage message2 = new IntMessage(2);
        IntMessage message3 = new IntMessage(5);

        IntMessage accumulatedMessage1 = (IntMessage) message1.accumulate(message2);
        IntMessage accumulatedMessage2 = (IntMessage) accumulatedMessage1.accumulate(message3);

        assertTrue(message1.isAbleToAccumulate(message2));
        assertTrue(message2.isAbleToAccumulate(message3));
        assertFalse(message3.isAbleToAccumulate(accumulatedMessage1));

        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(accumulatedMessage2.getMessage());
        //System.out.println(accumulatedMessage2.getMessage());
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
        assertNull(sut.accumulate(notAccumulatableMessage));
    }

    @Test
    public void charShouldNotBeAccumulatable() {
        CharMessage sut = new CharMessage('C');
        FlushMessage notAccumulatableMessage = new FlushMessage();
        CharMessage notAccumulatableCharMessage = new CharMessage('C');

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableCharMessage));
        assertNull(sut.accumulate(notAccumulatableMessage));
    }

    @Test
    public void flushShouldNotBeAccumulatable() {
        FlushMessage sut = new FlushMessage();
        BooleanMessage notAccumulatableMessage = new BooleanMessage(true);
        FlushMessage notAccumulatableFlushMessage = new FlushMessage();

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableFlushMessage));
        assertNull(sut.accumulate(notAccumulatableMessage));
    }

    @Test
    public void intArrayShouldNotBeAccumulatable() {
        IntArrayMessage sut = new IntArrayMessage(new int[] {1,2,3});
        FlushMessage notAccumulatableMessage = new FlushMessage();
        IntArrayMessage notAccumulatableIntArrayMessage = new IntArrayMessage(new int[] {4,5,6});

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableIntArrayMessage));
        assertNull(sut.accumulate(notAccumulatableMessage));
    }

    @Test
    public void intMatrixShouldNotBeAccumulatable() {
        IntMatrixMessage sut = new IntMatrixMessage(new int[][] {{1,2},{3,4}});
        FlushMessage notAccumulatableMessage = new FlushMessage();
        IntMatrixMessage notAccumulatableSameTypeMessage = new IntMatrixMessage(new int[][] {{5,6},{7,8}});

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableSameTypeMessage));
        assertNull(sut.accumulate(notAccumulatableMessage));
    }

    @Test
    public void referenceShouldNotBeAccumulatable() {
        ReferenceMessage sut = new ReferenceMessage(new Object());
        FlushMessage notAccumulatableMessage = new FlushMessage();
        ReferenceMessage notAccumulatableSameTypeMessage = new ReferenceMessage(new Object());

        assertFalse(sut.isAbleToAccumulate(notAccumulatableMessage));
        assertFalse(sut.isAbleToAccumulate(notAccumulatableSameTypeMessage));
        assertNull(sut.accumulate(notAccumulatableMessage));
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
