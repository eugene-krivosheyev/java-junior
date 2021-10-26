package com.acme.edu;

import com.acme.edu.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    private Message defaultStateStub;
    private Message anotherTypeMessageStub;
    private Saver saver;

    @BeforeEach
    public void setUp() {
        defaultStateStub = mock(Message.class);
        anotherTypeMessageStub = mock(Message.class);
        saver = mock(Saver.class);
    }


    @Test
    public void shouldFlushWhenLogDifferentTypeMessage() {

        when(defaultStateStub.isSameType(anotherTypeMessageStub)).thenReturn(false);
        when(defaultStateStub.decorate()).thenReturn("current state body");

        final Controller controllerSut = new Controller(saver);

        controllerSut.log(defaultStateStub);
        controllerSut.log(anotherTypeMessageStub);

        verify(saver).save("current state body");
    }

    @Test
    public void shouldNotFlushWhenLogSameTypeMessage() {

        when(defaultStateStub.isSameType(anotherTypeMessageStub)).thenReturn(true);

        final Controller controllerSut = new Controller(saver);

        controllerSut.log(defaultStateStub);
        controllerSut.log(anotherTypeMessageStub);

        verify(defaultStateStub).process(anotherTypeMessageStub);
    }

}
