package com.acme.edu.unittests;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.BoolMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntMessageTest {
    private Decorator stubDecorator = mock(DefaultDecorator.class);
    IntMessage sut = new IntMessage(1, stubDecorator);

    @Test
    public void shouldDecorateIntMessage() throws LoggerDecoratorException {
        when(stubDecorator.getDecoratedMessage()).thenReturn("primitive: 1");
        assertEquals("primitive: 1", sut.getDecoratedMessage());
    }

    @Test
    public void isSameTypeOfInt() {
        IntMessage anotherIntMessage = new IntMessage(2, stubDecorator);
        assertTrue(sut.isSameTypeOf(anotherIntMessage));
    }

    @Test
    public void isSameTypeOfString() {
        StringMessage stringMessage = new StringMessage("test", stubDecorator);
        assertFalse(sut.isSameTypeOf(stringMessage));
    }
}
