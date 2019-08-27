package com.acme.edu.mytest;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;
import org.junit.Test;
import com.acme.edu.*;
import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    @Test
    public void shouldSaveWithPrefixCommand() {
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);

        Command firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.decorate()).thenReturn("primitive: 1");
        when(firstStubCommand.getState()).thenReturn(StateCommand.INT);

        when(firstStubCommand.getMessage()).thenReturn(1);

        LoggerController loggerController = new LoggerController(mockSaver);

        loggerController.handleCommand(firstStubCommand);

        verify(mockSaver).saveWithPrefix(firstStubCommand);
    }

    @Test
    public void shouldSaveWithoutPrefixCommand() {
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);

        Command firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.decorate()).thenReturn("primitive: 1");
        when(firstStubCommand.getState()).thenReturn(StateCommand.INT);

        when(firstStubCommand.getMessage()).thenReturn(1);

        LoggerController loggerController = new LoggerController(mockSaver);

        loggerController.handleCommand(firstStubCommand);

        verify(mockSaver).saveWithoutPrefix(firstStubCommand);
    }
}