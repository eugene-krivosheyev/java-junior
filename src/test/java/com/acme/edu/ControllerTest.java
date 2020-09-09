package com.acme.edu;

import com.acme.edu.command.IntCommand;
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
    public void shouldCallAccumulateWhenLogIntSequence() {
        IntCommand firstIntCommand = mock(IntCommand.class);
        IntCommand secondIntCommand = mock(IntCommand.class);

        when(secondIntCommand.isSameType(firstIntCommand)).thenReturn(true);

        loggerController.log(firstIntCommand);
        loggerController.log(secondIntCommand);

        verify(loggerSaver, never()).saveMessage(any());
        verify(firstIntCommand).accumulate(secondIntCommand);
    }

    @Test
    public void shouldCallSaveWhenLogSequenceWithDifferentTypes() {
        IntCommand intCommand = mock(IntCommand.class);
        StringCommand stringCommand = mock(StringCommand.class);

        loggerController.log(intCommand);
        loggerController.log(stringCommand);

        verify(loggerSaver).saveMessage(intCommand);
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
