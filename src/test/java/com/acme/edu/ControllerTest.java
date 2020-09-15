package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.LoggerCommand;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.exception.IntLogException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.exception.StringLogException;
import com.acme.edu.saver.LoggerSaver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ControllerTest {
    private LoggerController loggerController;
    private LoggerSaver loggerSaver;

    @Before
    public void setUp() {
        loggerSaver = mock(LoggerSaver.class);
        loggerController = new LoggerController(loggerSaver);
    }

    @Test
    public void shouldSetCommandWhenFirstTimeLog() throws LogException, SaveException {
        LoggerCommand loggerCommand = mock(LoggerCommand.class);

        loggerController.log(loggerCommand);
        verify(loggerSaver, never()).saveMessage(any());
    }

    @Test
    public void shouldCallAccumulateWhenLogSameTypeSequence() throws LogException, StringLogException, IntLogException, SaveException {
        LoggerCommand firstCommand = mock(LoggerCommand.class);
        LoggerCommand secondCommand = mock(LoggerCommand.class);

        when(secondCommand.isSameType(firstCommand)).thenReturn(true);

        loggerController.log(firstCommand);
        loggerController.log(secondCommand);

        verify(loggerSaver, never()).saveMessage(any());
        verify(firstCommand).accumulate(secondCommand);
    }

    @Test
    public void shouldCallSaveWhenLogDifferentTypesSequence() throws LogException, StringLogException, SaveException{
        LoggerCommand firstCommand = mock(LoggerCommand.class);
        LoggerCommand secondCommand = mock(LoggerCommand.class);

        when(secondCommand.isSameType(firstCommand)).thenReturn(false);

        loggerController.log(firstCommand);
        loggerController.log(secondCommand);

        verify(loggerSaver).saveMessage(firstCommand);
        verify(loggerSaver, never()).saveMessage(secondCommand);
    }

    @Test
    public void shouldCallSaveWhenFlush()throws LogException, SaveException {
        IntCommand intCommand = mock(IntCommand.class);

        loggerController.log(intCommand);
        loggerController.flush(null);

        verify(loggerSaver).saveMessage(intCommand);
    }

    @Test(expected = LogException.class)
    public void shouldThrowLogExceptionWhenNewCommandIsNull() throws LogException {
        LoggerCommand firstCommand = mock(LoggerCommand.class);

        loggerController.log(firstCommand);
        loggerController.log(null);
    }

    @Test
    public void shouldThrowExceptionWithRightMessageWhenNewCommandIsNull() throws LogException {
        LoggerCommand firstCommand = mock(LoggerCommand.class);

        try {
            loggerController.log(firstCommand);
            loggerController.log(null);
        } catch (LogException e) {
            assertEquals("Invalid parameter exception: new command is null", e.getMessage());
        }
    }
}
