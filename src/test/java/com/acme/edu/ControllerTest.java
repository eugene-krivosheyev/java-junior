package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.LoggerCommand;
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

        try {
            loggerController.log(loggerCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(loggerSaver, never()).saveMessage(any());
    }

    @Test
    public void shouldCallAccumulateWhenLogSameTypeSequence() {
        LoggerCommand firstCommand = mock(LoggerCommand.class);
        LoggerCommand secondCommand = mock(LoggerCommand.class);

        when(secondCommand.isSameType(firstCommand)).thenReturn(true);

        try {
            loggerController.log(firstCommand);
            loggerController.log(secondCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(loggerSaver, never()).saveMessage(any());
        verify(firstCommand).accumulate(secondCommand);
    }

    @Test
    public void shouldCallSaveWhenLogDifferentTypesSequence() {
        LoggerCommand firstCommand = mock(LoggerCommand.class);
        LoggerCommand secondCommand = mock(LoggerCommand.class);

        when(secondCommand.isSameType(firstCommand)).thenReturn(false);

        try {
            loggerController.log(firstCommand);
            loggerController.log(secondCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }


        verify(loggerSaver).saveMessage(firstCommand);
        verify(loggerSaver, never()).saveMessage(secondCommand);
    }

    @Test
    public void shouldCallSaveWhenFlush() {
        IntCommand intCommand = mock(IntCommand.class);

        try {
            loggerController.log(intCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loggerController.flush();

        verify(loggerSaver).saveMessage(intCommand);
    }

    @Test
    public void shouldThrowExceptionWhenNewCommandIsNull() {
        IntCommand intCommand = mock(IntCommand.class);

        try {
            loggerController.log(intCommand);
            loggerController.log(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
