package com.acme.edu.test;

import com.acme.edu.Logger;
import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.LoggerSaver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    private LoggerController sut;
    private ConsoleLoggerSaver mockSaver;

    @Before
    public void setUp() {
        mockSaver = mock(ConsoleLoggerSaver.class);
        sut = new LoggerController(mockSaver);
    }


    @Test
    public void messageIsPrintedWhenFlush() {
        LoggerMessage dummyMessage = mock(LoggerMessage.class);
        LoggerMessage messageDoubler = mock(LoggerMessage.class);
        when(messageDoubler.getMessage()).thenReturn("test");
        when(messageDoubler.isSameType(dummyMessage)).thenReturn(false);
        when(messageDoubler.isNotOverflowed(dummyMessage)).thenReturn(true);

        sut.log(messageDoubler);
        sut.flush();
        verify(mockSaver).save(messageDoubler.getMessage());
    }

    @Test
    public void shouldSetUpStateWhenFirstMessage(){
        LoggerMessage dummyMessage = mock(LoggerMessage.class);
        LoggerMessage messageDoubler = mock(LoggerMessage.class);
        when(messageDoubler.isSameType(dummyMessage)).thenReturn(false);
        when(messageDoubler.isNotOverflowed(dummyMessage)).thenReturn(true);
        when(messageDoubler.getMessage()).thenReturn("test");

        sut.log(messageDoubler);
        sut.log(dummyMessage);

        verify(mockSaver).save(messageDoubler.getMessage());
    }

    @Test
    public void shouldAccumulateWhenCurrentMessageSameTypeWithLoggedMessage() {
        LoggerMessage firstMessageDoubler = mock(LoggerMessage.class);
        LoggerMessage secondMessageDoubler = mock(LoggerMessage.class);
        when(firstMessageDoubler.isSameType(secondMessageDoubler)).thenReturn(true);
        when(firstMessageDoubler.isNotOverflowed(secondMessageDoubler)).thenReturn(true);

        sut.log(firstMessageDoubler);
        sut.log(secondMessageDoubler);

        verify(firstMessageDoubler).accumulate(secondMessageDoubler);
        verify(mockSaver, never()).save(any());
    }
}
