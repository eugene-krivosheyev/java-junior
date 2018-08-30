package com.acme.edu.logger;

import com.acme.edu.controller.Controller;
import com.acme.edu.message.CharMessage;
import com.acme.edu.message.IntMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class IntMessageTest {

    private Controller testController = mock(Controller.class);

    @Test
    public void shouldBeSameType() {

        IntMessage firstMessage = new IntMessage(2);
        IntMessage secondMessage = new IntMessage(5);
        assertEquals(true, firstMessage.isSameTypeOf(secondMessage));
    }

    @Test
    public void shouldBeDifferentTypes() {

        IntMessage firstMessage = new IntMessage(2);
        CharMessage secondMessage = mock(CharMessage.class);
        assertEquals(false, firstMessage.isSameTypeOf(secondMessage));
    }

    @Test
    public void shouldAccumulateIntMessages(){

        IntMessage firstMessage = new IntMessage(2);
        IntMessage secondMessage = new IntMessage(5);
        assertEquals(7, ((IntMessage) firstMessage.accumulate(secondMessage)).getValue());
    }
}
