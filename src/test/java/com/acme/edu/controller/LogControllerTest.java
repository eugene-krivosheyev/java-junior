package com.acme.edu.controller;

import com.acme.edu.loggerexceptions.AccumulateException;
import com.acme.edu.loggerexceptions.SaverExceptions;
import com.acme.edu.messagelog.IntMessage;
import com.acme.edu.messagelog.LoggerDecorator;
import com.acme.edu.messagelog.Message;
import com.acme.edu.messagelog.StringMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.Times;
import org.mockito.verification.VerificationMode;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LogControllerTest {
    private LogController logController;
    private ConsoleLoggerSaver stubSaver;
    private LoggerDecorator stubDecorator;
    private StringMessage dummyMessage;

    @Before
    public void setUp() throws Exception {
        stubDecorator = mock(LoggerDecorator.class);
        dummyMessage = mock(StringMessage.class);
        stubSaver = mock(ConsoleLoggerSaver.class);
        logController = new LogController(stubSaver, stubDecorator);
    }

    @Test
    public void shouldAccumulateWhenGivenTwoMessagesOfTheSameType() throws AccumulateException {
        Message mockMessage1 = mock(Message.class);
        Message mockMessage2 = mock(Message.class);
        when(mockMessage1.canBeAccumulated(mockMessage2)).thenReturn(true);

        logController.log(mockMessage1);
        logController.log(mockMessage2);

        verify(mockMessage1).accumulate(mockMessage2);
    }

    @Test
    public void shouldNotAccumulateWhenGivenTwoMessagesOfDifferentTypes() throws AccumulateException {
        Message mockMessage1 = mock(Message.class);
        Message mockMessage2 = mock(Message.class);
        when(mockMessage1.canBeAccumulated(mockMessage2)).thenReturn(false);

        logController.log(mockMessage1);
        logController.log(mockMessage2);

        verify(mockMessage1, times(0)).accumulate(mockMessage2);
    }

    @Test
    public void shouldNotSaveWithoutNewMessages() throws SaverExceptions {
        String stubStringToFlush = "str";

        logController.flush();

        verify(stubSaver, times(0)).save(stubStringToFlush);
    }
}