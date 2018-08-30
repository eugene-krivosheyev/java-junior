package com.acme.edu.unittests;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ByteMessageTest {
    private Decorator stubDecorator = mock(DefaultDecorator.class);
    private ByteMessage sut = new ByteMessage((byte)1, stubDecorator);


    @Test
    public void shouldDecorateByteMessage() throws LoggerDecoratorException {
        when(stubDecorator.getDecoratedMessage()).thenReturn("primitive: 1");
        assertEquals("primitive: 1", sut.getDecoratedMessage());
    }

    @Test
    public void isSameTypeOfInt() {
        ByteMessage anotherByteMessage = new ByteMessage((byte)2, stubDecorator);
        assertTrue(sut.isSameTypeOf(anotherByteMessage));
    }

    @Test
    public void isSameTypeOfString() {
        StringMessage stringMessage = new StringMessage("test", stubDecorator);
        assertFalse(sut.isSameTypeOf(stringMessage));
    }
}
