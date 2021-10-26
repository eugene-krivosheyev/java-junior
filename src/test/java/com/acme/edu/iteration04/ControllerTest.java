package com.acme.edu.iteration04;

import com.acme.edu.Controller;
import com.acme.edu.Printer;
import com.acme.edu.messages.Message;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void shouldFlushWhenLogDifferentTypeMessage() {
        Printer printerStub = mock(Printer.class);
        Message differentTypeMessageSub = mock(Message.class);
        Message currentStateSub = mock(Message.class);
        when(currentStateSub.isSameType(differentTypeMessageSub)).thenReturn(false);
        when(currentStateSub.flush()).thenReturn("current state body");
        final Controller controllerSut = new Controller(printerStub);
        controllerSut.log(currentStateSub);
        controllerSut.log(differentTypeMessageSub);
        verify(printerStub).print("current state body");
    }

    @Test
    public void shouldInitWhenLogMessageAndStart() {
        Printer printerStub = mock(Printer.class);
        Message currentStateSub = mock(Message.class);
        final Controller controllerSut = new Controller(printerStub);
        controllerSut.log(currentStateSub);
        verify(currentStateSub, times(1)).init();
    }

    @Test
    public void shouldCallAccumulateWhenLogSameTypeMessage() {
        Printer printerStub = mock(Printer.class);
        Message sameTypeMessageSub = mock(Message.class);
        Message currentStateSub = mock(Message.class);
        when(currentStateSub.isSameType(sameTypeMessageSub)).thenReturn(true);
        final Controller controllerSut = new Controller(printerStub);
        controllerSut.log(currentStateSub);
        controllerSut.log(sameTypeMessageSub);
        verify(currentStateSub, times(1)).accumulate(sameTypeMessageSub);
    }

}