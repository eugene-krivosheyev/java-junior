package com.acme.edu;

import com.acme.edu.message.Message;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {
    @Test
    public void shouldFlushWhenLogDifferentTypeMessage(){
        Message defaultStateStub = mock(Message.class);
        Message differentTypeMessageStub = mock(Message.class);
        Controller controllerStub = mock(Controller.class);

        when(defaultStateStub.isSameType(differentTypeMessageStub)).thenReturn(false);

        final Logger controllerSut = new Logger();

        controllerStub.log(defaultStateStub);
        controllerStub.log(differentTypeMessageStub);


        verify(controllerStub).log(defaultStateStub);
    }
}
