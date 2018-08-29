package com.acme.edu.decorator;

import com.acme.edu.messagelog.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrefixLoggerDecoratorTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private PrefixLoggerDecorator decorator;

    @Before
    public void setUp() throws Exception {
        decorator = new PrefixLoggerDecorator();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenIntMessageIsNull() {
        IntMessage message = null;
        decorator.decorate(message);
    }

    @Test
    public void shouldDecorateAsIntWhenParameterIsIntMessage() {
        IntMessage message = mock(IntMessage.class);
        when(message.getValue()).thenReturn(1);
        when(message.getType()).thenReturn("primitive");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("primitive: 1", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsByteWhenParameterIsByteMessage() {
        ByteMessage message = mock(ByteMessage.class);
        when(message.getValue()).thenReturn((byte)1);
        when(message.getType()).thenReturn("primitive");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("primitive: 1", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsCharWhenParameterIsCharMessage() {
        CharMessage message = mock(CharMessage.class);
        when(message.getValue()).thenReturn('a');
        when(message.getType()).thenReturn("char");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("char: a", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsStringWhenParameterIsStringMessage() {
        StringMessage message = mock(StringMessage.class);
        when(message.getValue()).thenReturn("str 1");
        when(message.getType()).thenReturn("string");
        when(message.getStringCount()).thenReturn(1);

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("string: str 1", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsRepeatedStringWhenParameterIsRepeatedStringMessage() {
        StringMessage message = mock(StringMessage.class);
        when(message.getValue()).thenReturn("str 1");
        when(message.getType()).thenReturn("string");
        when(message.getStringCount()).thenReturn(3);

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("string: str 1 (x3)", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsBooleanWhenParameterIsBooleanMessage() {
        BooleanMessage message = mock(BooleanMessage.class);
        when(message.getValue()).thenReturn(true);
        when(message.getType()).thenReturn("boolean");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("boolean: true", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsObjectWhenParameterIsObjectMessage() {
        ObjectMessage message = mock(ObjectMessage.class);
        String objectReference= (new Object()).toString();
        when(message.getValue()).thenReturn(objectReference);
        when(message.getType()).thenReturn("reference");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("reference: " + objectReference, actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsIntArrayWhenParameterIsArrayIntMessage() {
        ArrayIntMessage message = mock(ArrayIntMessage.class);
        when(message.getValue()).thenReturn(new int[] {1, 1, 2});
        when(message.getType()).thenReturn("primitive array");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("primitive array: {1, 1, 2}", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsIntMatrixWhenParameterIsMatrixIntMessage() {
        MatrixIntMessage message = mock(MatrixIntMessage.class);
        when(message.getValue()).thenReturn(new int[][] {{1, 1, 2}, {1, 2}});
        when(message.getType()).thenReturn("primitive matrix");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals(
                "primitive matrix: {" + LINE_SEPARATOR +
                "{1, 1, 2}" + LINE_SEPARATOR +
                "{1, 2}" + LINE_SEPARATOR +
                "}",
                actualDecoratedMessage
        );
    }
}