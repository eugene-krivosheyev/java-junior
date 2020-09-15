package com.acme.edu.test;

import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.FileLoggerSaverException;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.FileLoggerSaver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    private LoggerController sut;
    private ConsoleLoggerSaver mockSaver;
    private LoggerController sut1;
    private FileLoggerSaver mockSaver1;

    @Before
    public void setUp() {
        mockSaver = mock(ConsoleLoggerSaver.class);
        sut = new LoggerController(mockSaver);
        mockSaver1 = mock(FileLoggerSaver.class);
        sut1 = new LoggerController(mockSaver1);
    }


    @Test
    public void messageIsPrintedWhenFlush() throws SaverException, FileLoggerSaverException {
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
    public void shouldSetUpStateWhenFirstMessage() throws SaverException, FileLoggerSaverException {
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
    public void shouldAccumulateWhenCurrentMessageSameTypeWithLoggedMessage() throws SaverException, FileLoggerSaverException {
        LoggerMessage firstMessageDoubler = mock(LoggerMessage.class);
        LoggerMessage secondMessageDoubler = mock(LoggerMessage.class);
        when(firstMessageDoubler.isSameType(secondMessageDoubler)).thenReturn(true);
        when(firstMessageDoubler.isNotOverflowed(secondMessageDoubler)).thenReturn(true);

        sut.log(firstMessageDoubler);
        sut.log(secondMessageDoubler);

        verify(firstMessageDoubler).accumulate(secondMessageDoubler);
        verify(mockSaver, never()).save(any());
    }
@Ignore
    @Test(expected = SaverException.class)
    public void shouldThrowSaverException() throws SaverException {
        IntMessage firstMessageDoubler = mock(IntMessage.class);
        when(firstMessageDoubler.getMessage()).thenReturn("1");
//        StringMessage secondMessageDoubler = mock(StringMessage.class);
//        when(secondMessageDoubler.getMessage()).thenReturn("1");

        sut1.log(firstMessageDoubler);
//        sut1.log(secondMessageDoubler);

        sut1.flush();
    }
}
