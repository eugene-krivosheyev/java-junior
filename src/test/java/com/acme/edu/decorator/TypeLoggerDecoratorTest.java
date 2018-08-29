package com.acme.edu.decorator;

import com.acme.edu.messagelog.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TypeLoggerDecoratorTest {
    private TypeLoggerDecorator decorator;

    @Before
    public void setUp() throws Exception {
        decorator = new TypeLoggerDecorator();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenIntMessageIsNull() {
        IntMessage message = null;
        decorator.decorate(message);
    }

    @Test
    public void shouldDecorateAsIntWhenParameterIsIntMessage() {
        IntMessage message = mock(IntMessage.class);
        when(message.getType()).thenReturn("primitive");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("This is primitive", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsByteWhenParameterIsByteMessage() {
        ByteMessage message = mock(ByteMessage.class);
        when(message.getType()).thenReturn("primitive");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("This is primitive", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsCharWhenParameterIsCharMessage() {
        CharMessage message = mock(CharMessage.class);
        when(message.getType()).thenReturn("char");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("This is char", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsStringWhenParameterIsStringMessage() {
        StringMessage message = mock(StringMessage.class);
        when(message.getType()).thenReturn("string");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("This is string", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsBooleanWhenParameterIsBooleanMessage() {
        BooleanMessage message = mock(BooleanMessage.class);
        when(message.getType()).thenReturn("boolean");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("This is boolean", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsObjectWhenParameterIsObjectMessage() {
        ObjectMessage message = mock(ObjectMessage.class);
        when(message.getType()).thenReturn("reference");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("This is reference", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsIntArrayWhenParameterIsArrayIntMessage() {
        ArrayIntMessage message = mock(ArrayIntMessage.class);
        when(message.getType()).thenReturn("primitive array");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals("This is primitive array", actualDecoratedMessage);
    }

    @Test
    public void shouldDecorateAsIntMatrixWhenParameterIsMatrixIntMessage() {
        MatrixIntMessage message = mock(MatrixIntMessage.class);
        when(message.getType()).thenReturn("primitive matrix");

        String actualDecoratedMessage = decorator.decorate(message);

        assertEquals(
                "This is primitive matrix",
                actualDecoratedMessage
        );
    }
}