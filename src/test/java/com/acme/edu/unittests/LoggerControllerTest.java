package com.acme.edu.unittests;

import com.acme.edu.LoggerController;
import com.acme.edu.LoggerSaver;
import com.acme.edu.Saver;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.FlushMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    LoggerSaver stubLoggerSaver = mock(LoggerSaver.class);
    LoggerController testLoggerController = new LoggerController(stubLoggerSaver);

    @Test
    public void shouldNotFailWhenAddFirstMessage() {
        Message stubStringMessage = mock(StringMessage.class);
        when(stubStringMessage.getDecoratedMessage()).thenReturn("str: message");

        Message stubFlushMessage = mock(FlushMessage.class);
        when(stubFlushMessage.getDecoratedMessage()).thenReturn("");

        testLoggerController.log(stubStringMessage);
        testLoggerController.log(stubFlushMessage);
        verify(stubLoggerSaver, times(1)).save(anyString());
    }

    @Test
    public void shouldAccumulateTwoMessagesOfTheStringType() {

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
        verify(stubLoggerSaver, times(1)).save(anyString());
    }

}
