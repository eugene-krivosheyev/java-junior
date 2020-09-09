package com.acme.edu.unittests;

import com.acme.edu.LoggerController;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.mockito.Mock;


public class LoggerControllerTest {
    static LoggerController loggerController;
    static Saver saver;

    @BeforeClass
    public static void setUp() {
        saver = mock(Saver.class);
        loggerController = new LoggerController(saver);
    }

    @Test
    public void shouldCorrectWorkWithIntMessage() {
        IntMessage message = mock(IntMessage.class);
        when(message.toString()).thenReturn("12");
        loggerController.log(message);
        loggerController.flush();

        verify(saver).save(message);
    }

    @Test
    public void shouldChangeStateIfNotSameMessageType() {
        IntMessage message = mock(IntMessage.class);
        when(message.toString()).thenReturn("12");
        loggerController.log(message);
        StringMessage messageStr = mock(StringMessage.class);
        when(message.toString()).thenReturn("12");
        loggerController.log(messageStr);

        verify(message).isSameType(messageStr);
        verify(message, times(0)).isOverFlow(messageStr);
        verify(message, times(0)).updateAccumulator(message);
    }
}
