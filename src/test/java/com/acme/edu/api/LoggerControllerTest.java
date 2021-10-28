package com.acme.edu.api;

import com.acme.edu.api.message.Message;
import com.acme.edu.api.message.NullMessageException;
import com.acme.edu.api.saver.Saver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class LoggerControllerTest {
    private LoggerController loggerController;
    private Message initialMessage;
    private Message secondMessage;
    private Saver saver;
    private NullMessageException exception;

    @BeforeEach
    public void setUpLoggerController() {
        exception = new NullMessageException("You try to write a Null Message");
        saver = mock(Saver.class);
        loggerController = new LoggerController(saver);
        initialMessage = mock(Message.class);
        secondMessage = mock(Message.class);
    }


    @Test
    public void shouldFlushWhenLogTwoDifferentTypesOfMessages() {
        when(initialMessage.typeEquals(null)).thenReturn(false);
        when(initialMessage.getMessageAsString()).thenReturn("initial message flush");
        when(initialMessage.typeEquals(secondMessage)).thenReturn(false);

        loggerController.log(initialMessage);
        loggerController.log(secondMessage);

        verify(saver).print("initial message flush");
    }

    @Test
    public void shouldCatchNullMessageException() throws NullMessageException {
        when(secondMessage.typeEquals(initialMessage)).thenReturn(true);
        when(initialMessage.accumulate(secondMessage)).thenThrow(exception);

        loggerController.log(initialMessage);
        loggerController.log(secondMessage);

        verify(saver).print(exception.getMessage());
    }

}
