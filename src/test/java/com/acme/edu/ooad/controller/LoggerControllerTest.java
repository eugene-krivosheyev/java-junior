package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.exception.FlushException;
import com.acme.edu.ooad.exception.LogException;
import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;
import com.acme.edu.ooad.saver.ValidatingSaver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    ValidatingSaver saverMock = mock(ValidatingSaver.class);
    LoggerController controllerSut = new LoggerController(saverMock);

    @Test
    public void shouldSaveLastLoggedMessageWhenFlushAndLastLoggedMessageIsNotNull() throws FlushException, SaveException {
        controllerSut.lastLoggedMessage = mock(Message.class);
        controllerSut.flush();

        verify(saverMock, times(1)).save(any(Message.class));
    }

//    @Test
//    public void shouldCleanLastLoggedMessageWhenFlush() throws LogException, FlushException {
//        Message messageStub = mock(Message.class);
//        when(messageStub.getBody()).thenReturn("body");
//        controllerSut.log(messageStub);
//
//        controllerSut.flush();
//        verify(controllerSut.lastLoggedMessage, times(1)).clean();
//    }
//
//    @Test
//    public void shouldBecomeLastLoggedWhenLogMessageAndLastLoggedMessageIsNull() throws LogException {
//        Message messageStub = mock(Message.class);
//        when(messageStub.getBody()).thenReturn("body");
//
//        controllerSut.log(messageStub);
//        assertEquals(messageStub, controllerSut.lastLoggedMessage);
//    }

    @Test
    public void shouldSaveInstanceToPrintWhenLogAndLastLoggedMessageIsNotNull() throws LogException {
        Message logMessageStub = mock(Message.class);
        controllerSut.lastLoggedMessage = mock(Message.class);
        Message saveMessageStub = mock(Message.class);
        when(controllerSut.lastLoggedMessage.getInstanceToPrint(logMessageStub))
                .thenReturn(saveMessageStub);

        controllerSut.log(logMessageStub);
        try {
            verify(saverMock, times(1)).save(saveMessageStub);
        } catch (SaveException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUpdateLastLoggedMessageWhenLogAndLastLoggedMessageIsNotNull() throws LogException {
        Message logMessageStub = mock(Message.class);
        Message newInstanceMessageStub = mock(Message.class);
        controllerSut.lastLoggedMessage = mock(Message.class);
        when(controllerSut.lastLoggedMessage.getNewInstance(logMessageStub))
                .thenReturn(newInstanceMessageStub);

        controllerSut.log(logMessageStub);
        assertEquals(newInstanceMessageStub, controllerSut.lastLoggedMessage);
    }
}
