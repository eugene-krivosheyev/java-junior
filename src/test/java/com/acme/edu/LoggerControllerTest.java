package com.acme.edu;

import com.acme.edu.message.LoggerMessage;
import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {

    private static LoggerMessage messageMock;
    private static Saver saverMock;
    private static LoggerController loggerController;

    @Before
    public void setUp() {
        messageMock = mock(LoggerMessage.class);
        saverMock = mock(Saver.class);
        loggerController = new LoggerController(saverMock);
    }

    @Test
    public void shouldAccumulateCurrentMessageWhenInitialMessage() {
        loggerController.log(messageMock);
        verify(messageMock).accumulateMessage(messageMock);
        verify(saverMock, times(0)).print(any());
    }

    @Test
    public void shouldSaveSameTypeMessages() {
        LoggerMessage sameTypeMessageMock = mock(LoggerMessage.class);
        when(messageMock.isSameType(sameTypeMessageMock)).thenReturn(true);

        loggerController.log(messageMock);
        loggerController.log(sameTypeMessageMock);

        verify(messageMock).accumulateMessage(messageMock);
        verify(messageMock).accumulateMessage(sameTypeMessageMock);
        verify(saverMock, times(0)).print(any());
    }

    @Test
    public void shouldPrintAndUpdateCurrentMessageWhenNotSameTypeAsPrevious() {
        LoggerMessage notSameTypeMessageMock = mock(LoggerMessage.class);
        when(messageMock.isSameType(notSameTypeMessageMock)).thenReturn(false);
        doNothing().when(saverMock).print(any());

        loggerController.log(messageMock);
        loggerController.log(notSameTypeMessageMock);

        verify(messageMock).accumulateMessage(messageMock);
        verify(messageMock, times(1)).printMessageBuffer(saverMock);
        verify(notSameTypeMessageMock).accumulateMessage(notSameTypeMessageMock);
    }

    @Test
    public void shouldFlush() {
        loggerController.log(messageMock);
        loggerController.flush();

        verify(messageMock, times(1)).printMessageBuffer(saverMock);
    }

    @Test
    public void shouldFlushWithoutNpeIfNothingLogged() {
        loggerController.flush();

        verify(messageMock, times(0)).printMessageBuffer(saverMock);
    }
}
