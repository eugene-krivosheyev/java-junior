package com.acme.edu.tests;

import commands.BooleanCommand;
import commands.Command;
import commands.IntCommand;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class IntCommandTest {
    IntCommand firstCommand;

    @Before
    public void setUp() {

        firstCommand = new IntCommand(5);

    }


    @Test
    public void shouldAccumulateWhenTwoIntCommands() {
        Command secondCommand = new IntCommand(6);

        Command accumulatedCommand = firstCommand.getAccumulated(secondCommand);

        assertThat(accumulatedCommand.getMessage()).isEqualTo(11);

    }

    @Test
    public void shouldDecorateIntCommand() {

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
        Command secondCommand = new IntCommand(6);

        boolean areCommandsEqual = firstCommand.equalsCommand(secondCommand);

        assertThat(areCommandsEqual).isEqualTo(true);

    }

    @Test
    public void shouldReturnFalseWhenComparingDifferentTypes() {
        Command secondCommand = new BooleanCommand(true);

        boolean areCommandsEqual = firstCommand.equalsCommand(secondCommand);

        assertThat(areCommandsEqual).isEqualTo(false);

    }
}
