package com.acme.edu.tests;

import com.acme.edu.LoggerController;
import com.acme.edu.Saver;
import commands.Command;
import commands.IntCommand;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {


    Saver mockSaver;
    LoggerController logger;
    Command firstCommand;

    @Before
    public void setUp() {
        mockSaver = mock(Saver.class);
        logger = new LoggerController(mockSaver);

        firstCommand = mock(IntCommand.class);
    }

    @Test
    public void shouldAccumulateWhenTwoIntCommands() {

        Command secondCommand = mock(IntCommand.class);

        when(firstCommand.equalsCommand(secondCommand)).thenReturn(true);
        when(firstCommand.getMessage()).thenReturn(2);
        when(secondCommand.getMessage()).thenReturn(3);
        when(firstCommand.getAccumulated(secondCommand)).thenReturn(new IntCommand(5));

        logger.log(firstCommand);
        logger.log(secondCommand);
        logger.flush();

        verify(firstCommand).equalsCommand(secondCommand);
        verify(mockSaver).save("primitive: 5");
    }

    @Test
    public void shouldReturnOneDecoratedMessageWhenFlushingAfterPassingOneCommand() {
        when(firstCommand.getDecorated()).thenReturn("deco: 5");
        logger.log(firstCommand);

        logger.flush();

        verify(mockSaver).save("deco: 5");

    }
}
