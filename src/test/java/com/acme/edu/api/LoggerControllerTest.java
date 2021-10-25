package com.acme.edu.api;
import com.acme.edu.api.message.IntegerMessage;
import com.acme.edu.api.message.Message;
import com.acme.edu.api.saver.Saver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    private static LoggerController loggerController;
    @Mock
    private static Saver saver;


    @Before
    public void setUpLoggerController() {
        saver = mock(Saver.class);
        loggerController = new LoggerController(saver);
    }


    @Test
    public void shouldFlushWhenLogTwoDifferentTypesOfMessages() {
        Message initialMessage = mock(Message.class);
        Message secondMessage = mock(Message.class);
        when(initialMessage.typeEquals(null)).thenReturn(false);
        when(initialMessage.getMessageAsString()).thenReturn("initial message flush");
        when(initialMessage.typeEquals(secondMessage)).thenReturn(false);

        loggerController.log(initialMessage);
        loggerController.log(secondMessage);
        verify(saver).print("initial message flush");
    }
}
