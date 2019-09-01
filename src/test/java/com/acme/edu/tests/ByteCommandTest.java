package com.acme.edu.tests;

import commands.BooleanCommand;
import commands.Command;
import commands.ByteCommand;
import exceptions.VarOverflowException;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ByteCommandTest {
    private ByteCommand firstCommand;

    @Before
    public void setUp() {

        firstCommand = new ByteCommand((byte) 5);

    }


    @Test
    public void shouldAccumulateWhenTwoByteCommands() {
        Command secondCommand = new ByteCommand((byte) 6);

        Command accumulatedCommand = firstCommand.getAccumulated(secondCommand);

        assertThat(accumulatedCommand.getMessage()).isEqualTo((byte) 11);

    }

    @Test
    public void shouldDecorateByteCommand() {

        String decoratedMessage = firstCommand.getDecorated();

        assertThat(decoratedMessage).isEqualToIgnoringCase("primitive: 5");
    }

    @Test
    public void shouldReturnMessageWhenGetMessage() {

        int firstCommandMessage = firstCommand.getMessage();

        assertThat(firstCommandMessage).isEqualTo(5);
    }

    @Test
    public void shouldReturnTrueWhenComparingSameIntType() {
        Command secondCommand = new ByteCommand((byte) 6);

        boolean areCommandsEqual = firstCommand.equalsCommand(secondCommand);

        assertThat(areCommandsEqual).isEqualTo(true);

    }

    @Test
    public void shouldReturnFalseWhenComparingDifferentTypes() {
        Command secondCommand = new BooleanCommand(true);

        boolean areCommandsEqual = firstCommand.equalsCommand(secondCommand);

        assertThat(areCommandsEqual).isEqualTo(false);

    }

    @Test(expected = VarOverflowException.class)
    public void shouldThrowExceptionIfOverflow() {
        Command secondCommand = new ByteCommand((byte) 127);

        firstCommand.checkOverflow(secondCommand);
    }

    @Test
    public void shouldNotThrowExceptionIfNoOverflow() {
        Command secondCommand = new ByteCommand((byte) 120);


        Command result = firstCommand.checkOverflow(secondCommand);

        assertThat(result.getMessage()).isEqualTo((byte) 125);
    }

}
