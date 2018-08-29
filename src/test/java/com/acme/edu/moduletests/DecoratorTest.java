package com.acme.edu.moduletests;

import com.acme.edu.decorator.*;
import com.acme.edu.message.*;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DecoratorTest {
    @Test
    public void shouldDecorateBoolean() {
        DefaultBooleanDecorator sut = new DefaultBooleanDecorator();
        BooleanMessage mockMessage = mock(BooleanMessage.class);
        when(mockMessage.getMessage()).thenReturn(true);

        String decoratedMessage = sut.decorate(mockMessage);

        assertEquals(decoratedMessage, "primitive: true");
    }

    @Test
    public void shouldDecorateByte() {
        DefaultByteDecorator sut = new DefaultByteDecorator();
        ByteMessage mockMessage = mock(ByteMessage.class);
        when(mockMessage.getMessage()).thenReturn((byte)42);

        String decoratedMessage = sut.decorate(mockMessage);

        assertEquals(decoratedMessage, "primitive: 42");
    }


    @Test
    public void shouldDecorateChar() {
        DefaultCharDecorator sut = new DefaultCharDecorator();
        CharMessage mockMessage = mock(CharMessage.class);
        when(mockMessage.getMessage()).thenReturn('A');

        String decoratedMessage = sut.decorate(mockMessage);

        assertEquals(decoratedMessage, "char: A");
    }

    @Test
    public void shouldDecorateInt() {
        DefaultIntDecorator sut = new DefaultIntDecorator();
        IntMessage mockMessage = mock(IntMessage.class);
        when(mockMessage.getMessage()).thenReturn(13);

        String decoratedMessage = sut.decorate(mockMessage);

        assertEquals(decoratedMessage, "primitive: 13");
    }

    @Test
    public void shouldDecorateIntWithBinaryDecorator() {
        BinaryIntDecorator sut = new BinaryIntDecorator();
        IntMessage mockMessage = mock(IntMessage.class);
        when(mockMessage.getMessage()).thenReturn(13);

        String decoratedMessage = sut.decorate(mockMessage);

        assertEquals(decoratedMessage, "1101");
    }

    @Test
    public void shouldDecorateIntArray() {
        DefaultIntArrayDecorator sut = new DefaultIntArrayDecorator();
        IntArrayMessage mockMessage = mock(IntArrayMessage.class);
        when(mockMessage.getMessage()).thenReturn(new int[] {1,2,3});

        String decoratedMessage = sut.decorate(mockMessage);

        assertEquals(decoratedMessage, "primitives array: {1, 2, 3}");
    }

    @Test
    public void shouldDecorateIntMatrix() {
        DefaultIntMatrixDecorator sut = new DefaultIntMatrixDecorator();
        IntMatrixMessage mockMessage = mock(IntMatrixMessage.class);
        when(mockMessage.getMessage()).thenReturn(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});

        String decoratedMessage = sut.decorate(mockMessage);

        assertEquals(decoratedMessage, "primitives matrix: {" + System.lineSeparator() +
                "{-1, 0, 1}" + System.lineSeparator() +
                "{1, 2, 3}" + System.lineSeparator() +
                "{-1, -2, -3}" + System.lineSeparator() +
                "}"
        );
    }

    @Test
    public void shouldDecorateReference() {
        DefaultReferenceDecorator sut = new DefaultReferenceDecorator();
        ReferenceMessage mockMessage = mock(ReferenceMessage.class);
        when(mockMessage.getMessage()).thenReturn(new Object());

        String decoratedMessage = sut.decorate(mockMessage);

        assertThat(decoratedMessage).contains("reference: ");
        assertThat(decoratedMessage).contains("@");
    }

    @Test
    public void shouldDecorateString() {
        DefaultStringDecorator sut = new DefaultStringDecorator();
        StringMessage mockMessage = mock(StringMessage.class);
        when(mockMessage.getMessage()).thenReturn("test string");

        String decoratedMessage = sut.decorate(mockMessage);

        assertEquals(decoratedMessage, "string: test string");
    }
}
