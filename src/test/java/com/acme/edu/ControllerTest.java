package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.saver.LoggerSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


import static org.mockito.Mockito.*;

public class ControllerTest implements SysoutCaptureAndAssertionAbility {
    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldSetCurrentCommandWhenTheFirstCall() {
        LoggerSaver loggerSaver = mock(LoggerSaver.class);
        LoggerController loggerController = new LoggerController(loggerSaver);
        IntCommand intCommand = new IntCommand(3);
        doAnswer(invocation -> {
            System.out.println("primitive: 3");
            return null;
        }).when(loggerSaver).saveMessage(intCommand);

        loggerController.log(intCommand);
        loggerController.flush();

        assertSysoutContains("primitive: 3");
    }

    @Test
    public void shouldCallAccumulateWhenLogIntSequence() {
        LoggerSaver loggerSaver = mock(LoggerSaver.class);
        LoggerController loggerController = new LoggerController(loggerSaver);
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
        LoggerSaver loggerSaver = mock(LoggerSaver.class);
        LoggerController loggerController = new LoggerController(loggerSaver);
        IntCommand intCommand = mock(IntCommand.class);
        StringCommand stringCommand = mock(StringCommand.class);

        loggerController.log(intCommand);
        loggerController.log(stringCommand);

        verify(loggerSaver).saveMessage(intCommand);
    }

    @Test
    public void shouldCallSaveWhenFlush() {
        LoggerSaver loggerSaver = mock(LoggerSaver.class);
        LoggerController loggerController = new LoggerController(loggerSaver);
        IntCommand intCommand = mock(IntCommand.class);
        StringCommand stringCommand = mock(StringCommand.class);

        loggerController.log(intCommand);
        loggerController.log(stringCommand);
        loggerController.flush();

        verify(loggerSaver).saveMessage(intCommand);
        verify(loggerSaver).saveMessage(stringCommand);
    }
}
