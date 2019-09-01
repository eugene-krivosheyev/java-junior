package com.acme.edu.tests;

import commands.BooleanCommand;
import commands.Command;
import commands.IntCommand;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BooleanCommandTest {
    private BooleanCommand firstCommand;

    @Before
    public void setUp() {

        firstCommand = new BooleanCommand(true);

    }


    @Test
    public void shouldAccumulateWhenTwoBooleanCommands() {
        Command secondCommand = new BooleanCommand(true);

        Command accumulatedCommand = firstCommand.getAccumulated(secondCommand);

        assertThat(accumulatedCommand.getMessage()).isEqualTo(true);

    }

    @Test
    public void shouldDecorateBooleanCommand() {

        String decoratedMessage = firstCommand.getDecorated();

        assertThat(decoratedMessage).isEqualToIgnoringCase("primitive: true");
    }

    @Test
    public void shouldReturnMessageWhenGetMessage() {

        boolean firstCommandMessage = firstCommand.getMessage();

        assertThat(firstCommandMessage).isEqualTo(true);
    }

    @Test
    public void shouldReturnTrueWhenComparingSameIntType() {
        Command secondCommand = new BooleanCommand(true);

        boolean areCommandsEqual = firstCommand.equalsCommand(secondCommand);

        assertThat(areCommandsEqual).isEqualTo(true);

    }

    @Test
    public void shouldReturnFalseWhenComparingDifferentTypes() {
        Command secondCommand = new IntCommand(5);

        boolean areCommandsEqual = firstCommand.equalsCommand(secondCommand);

        assertThat(areCommandsEqual).isEqualTo(false);

    }
}
