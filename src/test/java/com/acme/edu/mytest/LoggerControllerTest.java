package com.acme.edu.mytest;

import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.SaverException;
import org.junit.Ignore;
import org.junit.Test;
import com.acme.edu.*;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {

    @Test
    public void shouldSaveWithPrefixCommand() throws SaverException {
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        IntCommand firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.decorate()).thenReturn("primitive: 1");
        when(firstStubCommand.getState()).thenReturn(StateCommand.INT);
        when(firstStubCommand.getMessage()).thenReturn(1);
        LoggerController loggerController = new LoggerController(mockSaver);
        loggerController.handleCommand(firstStubCommand, new LinkedList<>());
        verify(mockSaver).saveWithPrefix(firstStubCommand);
    }

    @Test @Ignore
    public void shouldSaveWithoutPrefixCommand() throws SaverException {
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        IntCommand firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.decorate()).thenReturn("primitive: 1");
        when(firstStubCommand.getMessage()).thenReturn(1);
        when(firstStubCommand.getState()).thenReturn(StateCommand.INT);
        LoggerController loggerController = new LoggerController(mockSaver);
        loggerController.handleCommand(firstStubCommand, new LinkedList<>());
        verify(mockSaver).saveWithoutPrefix(firstStubCommand);
    }
}