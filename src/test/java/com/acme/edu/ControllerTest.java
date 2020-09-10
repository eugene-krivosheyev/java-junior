package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.LoggerCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.saver.LoggerSaver;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest implements SysoutCaptureAndAssertionAbility {
    private LoggerController loggerController;
    private LoggerSaver loggerSaver;

    @Before
    public void setUp() {
        loggerSaver = mock(LoggerSaver.class);
        loggerController = new LoggerController(loggerSaver);
    }

    @Test
    public void shouldSetCommandWhenFirstTimeLog(){
        LoggerCommand loggerCommand = mock(LoggerCommand.class);

        loggerController.log(loggerCommand);
        verify(loggerSaver, never()).saveMessage(any());
    }

    @Test
    public void shouldCallAccumulateWhenLogSameTypeSequence() {
        LoggerCommand firstCommand = mock(LoggerCommand.class);
        LoggerCommand secondCommand = mock(LoggerCommand.class);

        when(secondCommand.isSameType(firstCommand)).thenReturn(true);

        loggerController.log(firstCommand);
        loggerController.log(secondCommand);

        verify(loggerSaver, never()).saveMessage(any());
        verify(firstCommand).accumulate(secondCommand);
    }

    @Test
    public void shouldCallSaveWhenLogDifferentTypesSequence() {
        LoggerCommand firstCommand = mock(LoggerCommand.class);
        LoggerCommand secondCommand = mock(LoggerCommand.class);

        when(secondCommand.isSameType(firstCommand)).thenReturn(false);

        loggerController.log(firstCommand);
        loggerController.log(secondCommand);

        verify(loggerSaver).saveMessage(firstCommand);
        verify(loggerSaver, never()).saveMessage(secondCommand);
    }

    @Test
    public void shouldCallSaveWhenFlush() {
        IntCommand intCommand = mock(IntCommand.class);

        loggerController.log(intCommand);
        loggerController.flush();

        verify(loggerSaver).saveMessage(intCommand);
    }

    @Test
    public void shouldCallSaveWhenNewCommandIsNull(){
        IntCommand intCommand = mock(IntCommand.class);

        loggerController.log(intCommand);
        loggerController.log(null);

        verify(loggerSaver).saveMessage(intCommand);
    }
}
