package com.acme.edu.unittests;

import com.acme.edu.message.BoolMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoolMessageTest {

    private Decorator stubDecorator = mock(DefaultDecorator.class);

    @Test
    public void shouldDecorateBoolMessageTrue() {
        when(stubDecorator.getDecoratedMessage()).thenReturn("primitive: true");
        BoolMessage sut = new BoolMessage(true,stubDecorator);
        assertEquals("primitive: true", sut.getDecoratedMessage());
    }

    @Test
    public void shouldDecorateBoolMessageFalse() {
        when(stubDecorator.getDecoratedMessage()).thenReturn("primitive: false");
        BoolMessage sut = new BoolMessage(true,stubDecorator);
        assertEquals("primitive: false", sut.getDecoratedMessage());
    }

    @Test
    public void shouldNotAccumulate() {
        BoolMessage sut = new BoolMessage(true,stubDecorator);
        BoolMessage anotherMessage = new BoolMessage(false,stubDecorator);
        assertNull(sut.accumulate(anotherMessage));
    }

    @Test
    public void isSameTypeOfWithIntIsFalse() {
        BoolMessage sut = new BoolMessage(true,stubDecorator);
        IntMessage stubMessage = mock (IntMessage.class);
        assertFalse(sut.isSameTypeOf(stubMessage));
    }
}
