package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.Message;
import com.acme.edu.ooad.saver.Saver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    Saver saverMock = mock(Saver.class);
    LoggerController controllerSut = new LoggerController(saverMock);

    @Test
    public void shouldNotSaveLastLoggedMessageWhenFlushAndLastLoggedIsNull() {
        controllerSut.lastLoggedMessage = null;
        controllerSut.flush();

        verify(saverMock, times(0)).save(controllerSut.lastLoggedMessage);
    }

    @Test
    public void shouldSaveLastLoggedMessageWhenFlushAndLastLoggedMessageIsNotNull() {
        controllerSut.lastLoggedMessage = mock(Message.class);
        controllerSut.flush();

        verify(saverMock, times(1)).save(controllerSut.lastLoggedMessage);
    }

    @Test
    public void shouldCleanLastLoggedMessageWhenFlush() {
        Message messageStub = mock(Message.class);
        controllerSut.log(messageStub);

        controllerSut.flush();
        verify(controllerSut.lastLoggedMessage, times(1)).clean();
    }

    @Test
    public void shouldBecomeLastLoggedWhenLogMessageAndLastLoggedMessageIsNull() {
        Message messageStub = mock(Message.class);

        controllerSut.log(messageStub);
        assertEquals(messageStub, controllerSut.lastLoggedMessage);
    }

    @Test
    public void shouldSaveInstanceToPrintWhenLogAndLastLoggedMessageIsNotNull() {
        Message logMessageStub = mock(Message.class);
        controllerSut.lastLoggedMessage = mock(Message.class);
        Message saveMessageStub = mock(Message.class);
        when(controllerSut.lastLoggedMessage.getInstanceToPrint(logMessageStub))
                .thenReturn(saveMessageStub);

        controllerSut.log(logMessageStub);
        verify(saverMock, times(1))
                .save(saveMessageStub);
    }

    @Test
    public void shouldUpdateLastLoggedMessageWhenLogAndLastLoggedMessageIsNotNull() {
        Message logMessageStub = mock(Message.class);
        Message newInstanceMessageStub = mock(Message.class);
        controllerSut.lastLoggedMessage = mock(Message.class);
        when(controllerSut.lastLoggedMessage.getNewInstance(logMessageStub))
                .thenReturn(newInstanceMessageStub);

        controllerSut.log(logMessageStub);
        assertEquals(newInstanceMessageStub, controllerSut.lastLoggedMessage);
    }
}
