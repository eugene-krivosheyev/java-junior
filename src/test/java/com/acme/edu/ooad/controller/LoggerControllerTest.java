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
    public void shouldSaveLastLoggedMessageWhenFlushAndLastLoggedMessageIsNotNull(){
        Message messageStub = mock(Message.class);
        controllerSut.lastLoggedMessage = messageStub;
        try {
            controllerSut.flush();
        } catch (FlushException e) {
            e.printStackTrace();
        }

        try {
            verify(saverMock, times(1)).save(messageStub);
        } catch (SaveException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetFlushErrorWhenSaverGetError() throws SaveException{
        Message emptyMessageStub = mock(Message.class);
        controllerSut.lastLoggedMessage = emptyMessageStub;
        doThrow(SaveException.class).when(saverMock).save(emptyMessageStub);

        assertThrows(
                FlushException.class,
                () -> controllerSut.flush()
        );
    }

    @Test
    public void shouldGetLogErrorWhenSaverGetError() throws SaveException{
        Message messageStub = mock(Message.class);

        Message lastLoggedMessageStub = mock(Message.class);
        when(lastLoggedMessageStub.getInstanceToPrint(any())).thenReturn(messageStub);
        controllerSut.lastLoggedMessage = lastLoggedMessageStub;

        doThrow(SaveException.class).when(saverMock).save(messageStub);

        assertThrows(
                LogException.class,
                () -> controllerSut.log(messageStub)
        );
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
    public void shouldSaveInstanceToPrintWhenLogAndLastLoggedMessageIsNotNull(){
        Message logMessageStub = mock(Message.class);
        controllerSut.lastLoggedMessage = mock(Message.class);
        Message saveMessageStub = mock(Message.class);
        when(controllerSut.lastLoggedMessage.getInstanceToPrint(logMessageStub))
                .thenReturn(saveMessageStub);

        try {
            controllerSut.log(logMessageStub);
        } catch (LogException e) {
            e.printStackTrace();
        }
        try {
            verify(saverMock, times(1)).save(saveMessageStub);
        } catch (SaveException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUpdateLastLoggedMessageWhenLogAndLastLoggedMessageIsNotNull(){
        Message logMessageStub = mock(Message.class);
        Message newInstanceMessageStub = mock(Message.class);
        controllerSut.lastLoggedMessage = mock(Message.class);
        when(controllerSut.lastLoggedMessage.getNewInstance(logMessageStub))
                .thenReturn(newInstanceMessageStub);

        try {
            controllerSut.log(logMessageStub);
        } catch (LogException e) {
            e.printStackTrace();
        }
        assertEquals(newInstanceMessageStub, controllerSut.lastLoggedMessage);
    }
}
