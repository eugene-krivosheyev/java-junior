package com.acme.edu;

import com.acme.edu.message.Message;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {
    @Test
    public void shouldFlushWhenLogDifferentTypeMessage(){
        Message defaultStateStub = mock(Message.class);
        Message differentTypeMessageStub = mock(Message.class);
        Saver saver = mock(Saver.class);

        when(defaultStateStub.isSameType(differentTypeMessageStub)).thenReturn(false);
        when(defaultStateStub.decorate()).thenReturn("current state body");

        final Controller controllerSut = new Controller(saver);

        controllerSut.log(defaultStateStub);
        controllerSut.log(differentTypeMessageStub);

        verify(saver).save("current state body");
    }

//    @Test
//    public void success() {
//        Message messageStub = mock(Message.class);
//        Saver saverStub = mock(Saver.class);
//        when(new Controller())
//    }
}
