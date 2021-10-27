package com.acme.edu.iteration04;

import com.acme.edu.Controller;
import com.acme.edu.IllegalStringToPrintExeption;
import com.acme.edu.LogException;
import com.acme.edu.Printer;
import com.acme.edu.messages.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ControllerTest {
    Printer printerStub;
    Message differentTypeMessageSub;
    Message currentStateSub;
    Message sameTypeMessageSub;

    @BeforeEach
    public void SetUpSystem(){
        printerStub = mock(Printer.class);
        differentTypeMessageSub = mock(Message.class);
        currentStateSub = mock(Message.class);
        sameTypeMessageSub = mock(Message.class);
    }

    @Test
    public void shouldFlushWhenLogDifferentTypeMessage() throws IllegalStringToPrintExeption {
        when(currentStateSub.isSameType(differentTypeMessageSub)).thenReturn(false);
        when(currentStateSub.flush()).thenReturn("current state body");
        final Controller controllerSut = new Controller(printerStub);
        controllerSut.log(currentStateSub);
        controllerSut.log(differentTypeMessageSub);
        verify(printerStub).print("current state body");
    }

    @Test
    public void shouldInitWhenLogMessageAndStart() {
        final Controller controllerSut = new Controller(printerStub);
        controllerSut.log(currentStateSub);
        assertTrue(true);
    }

    @Test
    public void shouldCallAccumulateWhenLogSameTypeMessage() {

        when(currentStateSub.isSameType(sameTypeMessageSub)).thenReturn(true);
        final Controller controllerSut = new Controller(printerStub);
        controllerSut.log(currentStateSub);
        controllerSut.log(sameTypeMessageSub);
        verify(currentStateSub, times(1)).accumulate(sameTypeMessageSub);
    }

    @Test
    public void shouldNotLogWhenNullMessage() {
        final Controller controllerSut = new Controller(printerStub);
        final IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,()->controllerSut.log(null));
        assertThat(thrown).hasMessage("null message");
    }

    @Test
    public void shouldNotPrintWhenMessageIsNullString() {
        final Printer printerSut = new Printer();
        final Controller controllerSut = new Controller(printerSut);
        when(currentStateSub.isSameType(differentTypeMessageSub)).thenReturn(false);
        when(currentStateSub.flush()).thenReturn("");
        controllerSut.log(currentStateSub);
        final LogException thrown = assertThrows(LogException.class,()->controllerSut.log(differentTypeMessageSub));
       assertThat(thrown).hasMessage("Can't print message!");
    }

}