package com.acme.edu.iteration04;

import com.acme.edu.LoggerController;
import com.acme.edu.Saver;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class LoggerConrollerTest {

    @Test
    public void shouldInvokeSaveMethodWhenGetInitialMessage() {
        LoggerController loggerController = new LoggerController();
        IntMessage message = new IntMessage(10);
        Saver mock = mock(Saver.class);
        loggerController.setSaver(mock);

        loggerController.log(message);

        verify(mock, times(1)).save(message.decorate());
    }

    @Test
    public void shouldInvokeAccumulateWhenGetTwoSameTypeMessagesInARow() {
        LoggerController loggerController = new LoggerController();
        StringMessage firstMessage = mock(StringMessage.class);
        StringMessage secondMessage = mock(StringMessage.class);

        Saver saverMock = mock(Saver.class);
        loggerController.setSaver(saverMock);

        when(firstMessage.isInstanceOf(secondMessage)).thenReturn(true);

        loggerController.log(firstMessage);
        loggerController.log(secondMessage);

        verify(firstMessage, times(1)).accumulate(secondMessage);
    }

}
