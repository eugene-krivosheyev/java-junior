package com.acme.edu.api;

import com.acme.edu.api.message.Message;
import com.acme.edu.api.message.ObjectRefMessage;
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

    @BeforeEach
    public void setUpLoggerController() {
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
    public void shouldAccumulateTheCurrentMessage() {
        when(secondMessage.typeEquals(initialMessage)).thenReturn(true);

        loggerController.log(initialMessage);
        loggerController.log(secondMessage);

        verify(initialMessage).accumulate(secondMessage);
    }

}
