package com.acme.edu.unittests;

import com.acme.edu.LoggerController;
import com.acme.edu.ConsoleLoggerSaver;
import com.acme.edu.loggerexceptions.*;
import com.acme.edu.message.FlushMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    private ConsoleLoggerSaver stubConsoleLoggerSaver = mock(ConsoleLoggerSaver.class);
    private LoggerController testLoggerController = new LoggerController(stubConsoleLoggerSaver);

    @Test
    public void shouldNotFailWhenAddFirstMessage() throws LoggerException {
        Message stubStringMessage = mock(StringMessage.class);
        when(stubStringMessage.getDecoratedMessage()).thenReturn("str: message");

        Message stubFlushMessage = mock(FlushMessage.class);
        when(stubFlushMessage.getDecoratedMessage()).thenReturn("");

        testLoggerController.log(stubStringMessage);
        testLoggerController.log(stubFlushMessage);
        verify(stubConsoleLoggerSaver).save("str: message");
    }

    @Test
    public void shouldAccumulateTwoMessagesOfTheStringType() throws LoggerException {

        Message stubStringMessage = mock(StringMessage.class);
        when(stubStringMessage.isSameTypeOf(any(StringMessage.class))).thenReturn(true);
        when(stubStringMessage.isSameTypeOf(any(FlushMessage.class))).thenReturn(false);

        when(stubStringMessage.accumulate(Mockito.any())).thenReturn(stubStringMessage);
        when(stubStringMessage.getDecoratedMessage()).thenReturn("string: str (x2)");
        Message stubFlushMessage = mock(FlushMessage.class);
        when(stubFlushMessage.isSameTypeOf(Mockito.any())).thenReturn(false);
        when(stubFlushMessage.getDecoratedMessage()).thenReturn("");

        testLoggerController.log(stubStringMessage);
        testLoggerController.log(stubFlushMessage);
        verify(stubConsoleLoggerSaver).save("string: str (x2)");
    }

}
