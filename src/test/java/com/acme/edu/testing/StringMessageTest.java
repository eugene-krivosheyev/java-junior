package com.acme.edu.testing;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.MessageException;
import com.acme.edu.saver.Saver;
import org.junit.Test;
import com.acme.edu.message.StringMessage;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringMessageTest {
    @Test
    public void SameStringInARowAccumulation() throws MessageException {
        String message = "hello";
        Saver saver = mock(Saver.class);
        Decorator decorator = mock(Decorator.class);
        when(decorator.decorate("hello (x2)")).thenReturn("hello (x2)");
        StringMessage stringMessage = new StringMessage (message, saver, decorator);
        StringMessage stringMessage2 = new StringMessage (message, saver, decorator);
        stringMessage.accumulate(stringMessage2);
        assertEquals("hello (x2)" + System.lineSeparator(), stringMessage.fetch());
    }
}