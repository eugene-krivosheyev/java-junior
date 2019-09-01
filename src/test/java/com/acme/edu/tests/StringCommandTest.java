package com.acme.edu.tests;

import commands.BooleanCommand;
import commands.Command;
import commands.StringCommand;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StringCommandTest {
    private StringCommand firstCommand;

    @Before
    public void setUp() {

        firstCommand = new StringCommand("dummy1");

    }


    @Test
    public void shouldAccumulateWhenTwoStringCommands() {
        Command secondCommand = new StringCommand("dummy1");

        Command accumulatedCommand = firstCommand.getAccumulated(secondCommand);

        assertThat(accumulatedCommand.getMessage()).isEqualTo("dummy1");
    }

    @Test
    public void shouldDecorateStringCommand() {

        String decoratedMessage = firstCommand.getDecorated();

        assertThat(decoratedMessage).isEqualToIgnoringCase("string: dummy1");
    }

    @Test
    public void shouldDecorateAccumulatedStringCommand() {
        Command secondCommand = new StringCommand("dummy1");

        Command accumulatedCommand = firstCommand.getAccumulated(secondCommand);
        String decoratedMessage = accumulatedCommand.getDecorated();

        assertThat(decoratedMessage).isEqualToIgnoringCase("string: dummy1 (x2)");
    }


    @Test
    public void shouldReturnMessageWhenGetMessage() {

        String firstCommandMessage = firstCommand.getMessage();

        assertThat(firstCommandMessage).isEqualTo("dummy1");
    }

    @Test
    public void shouldReturnTrueWhenComparingSameStringType() {
        Command secondCommand = new StringCommand("dummy1");

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
