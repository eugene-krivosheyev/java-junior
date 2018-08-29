package com.acme.edu.iteration04;

import com.acme.edu.LoggerController;
import com.acme.edu.Saver;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerConrollerTest {

    @Test
    public void shouldInvokeOneTimeSaveMethodWhenGetTheFirstMessage() {
        LoggerController loggerController = new LoggerController();
        IntMessage stubIntMessage = mock(IntMessage.class);
        Saver mockSaver = mock(Saver.class);
        loggerController.setSaver(mockSaver);

        loggerController.log(stubIntMessage);

        verify(mockSaver, times(1)).save(stubIntMessage.decorate());
    }

    @Test
    public void shouldInvokeOneTimeAccumulateWhenGetTwoSameTypedMessagesInARow() {
        LoggerController loggerController = new LoggerController();
        StringMessage firstMessage = mock(StringMessage.class);
        StringMessage secondMessage = mock(StringMessage.class);

        Saver saverMock = mock(Saver.class);
        loggerController.setSaver(saverMock);

        loggerController.log(firstMessage);
        when(firstMessage.isInstanceOf(secondMessage)).thenReturn(true);
        loggerController.log(secondMessage);

        verify(firstMessage, times(1)).accumulate(secondMessage);
    }

    @Test
    public void shouldInvokeTwoTimesSaveForTheFirstMessageWhenGetTwoDifferentlyTypedMessagesInARow() {
        LoggerController loggerController = new LoggerController();
        StringMessage firstStringMessage = mock(StringMessage.class);
        IntMessage secondIntMessage = mock(IntMessage.class);

        Saver saverMock = mock(Saver.class);
        loggerController.setSaver(saverMock);

        when(firstStringMessage.decorate()).thenReturn(firstStringMessage);

        loggerController.log(firstStringMessage);
        when(firstStringMessage.isInstanceOf(secondIntMessage)).thenReturn(false);
        loggerController.log(secondIntMessage);

        verify(saverMock, times(2)).save(firstStringMessage);
    }

    @Test
    public void shouldInvokeTwoTimseSaveForMessageWhenFlushIsCalled() {
        LoggerController loggerController = new LoggerController();
        StringMessage stubStringMessage = mock(StringMessage.class);

        Saver saverMock = mock(Saver.class);
        loggerController.setSaver(saverMock);

        when(stubStringMessage.decorate()).thenReturn(stubStringMessage);

        loggerController.log(stubStringMessage);

        verify(saverMock, times(1)).save(stubStringMessage);

        loggerController.flush();

        verify(saverMock, times(2)).save(stubStringMessage);
    }
}
