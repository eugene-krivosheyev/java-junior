package com.acme.edu.unittests;

import com.acme.edu.LoggerController;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaverException;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class LoggerControllerTest {
    static LoggerController loggerController;
    static Saver saver;

    @Before
    public void setUp() {
        saver = mock(Saver.class);
        loggerController = new LoggerController(saver);
    }

    @Test
    public void shouldCorrectWorkWithIntMessage() throws LogException, SaverException {
        IntMessage message = mock(IntMessage.class);
        when(message.toString()).thenReturn("12");
        loggerController.log(message);
        loggerController.flush();

        verify(saver).save(message);
    }

    @Test
    public void shouldChangeStateIfNotSameMessageType() throws LogException {
        IntMessage message = mock(IntMessage.class);
        when(message.toString()).thenReturn("12");
        loggerController.log(message);
        StringMessage messageStr = mock(StringMessage.class);
        when(message.toString()).thenReturn("12");
        loggerController.log(messageStr);

        verify(message).isSameType(messageStr);
        verify(message, times(0)).needFlush(messageStr);
        verify(message, times(0)).updateAccumulator(message);
    }

    @Test(expected = LogException.class)
    public void shouldThrowLogExceptionWhenGotSaverException() throws SaverException, LogException {
        doThrow(SaverException.class).when(saver).save(any());
        Message message = mock(Message.class);
        loggerController.log(message);
        when(message.isSameType(any())).thenReturn(false);
        loggerController.log(mock(Message.class));
    }
}
