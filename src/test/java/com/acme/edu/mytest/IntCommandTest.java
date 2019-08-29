package com.acme.edu.mytest;

import com.acme.edu.commands.ByteCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.IntCommand;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class IntCommandTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenIntegerOverflowWhileAccumulating() {
        IntCommand firstCommand = new IntCommand(10);
        IntCommand secondCommand = new IntCommand(Integer.MAX_VALUE);

        firstCommand.accumulate(secondCommand).getDecorated();

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenTryingToAccumulateWithOtherType() {
        IntCommand firstCommand = new IntCommand(10);
        ByteCommand secondCommand = new ByteCommand((byte) 10);

        firstCommand.accumulate(secondCommand);
    }

    @Test
    public void shouldReturnFalseWhenCallingIsTypeEqualsWithAnotherType() {
        IntCommand firstCommand = new IntCommand(10);
        ByteCommand secondCommand = new ByteCommand((byte) 10);

        Assertions.assertThat(firstCommand.isTypeEquals(secondCommand)).isEqualTo(false);
    }

    @Test
    public void shouldReturnTrueWhenCallingIsTypeEqualsWithSameType() {
        IntCommand firstCommand = new IntCommand(10);
        IntCommand secondCommand = new IntCommand(10);

        Assertions.assertThat(firstCommand.isTypeEquals(secondCommand)).isEqualTo(true);
    }

    @Test
    public void shouldBeDecoratedCorrectly() {
        IntCommand command = new IntCommand(10);

        Assertions.assertThat(command.getDecorated()).isEqualTo(Command.PRIMITIVE_PREFIX + "10");
    }

    @Test
    public void shouldAccumulateReturnMessageIfNotException() {
        IntCommand firstCommand = new IntCommand(10);
        IntCommand secondCommand = new IntCommand(20);

        IntCommand result = firstCommand.accumulate(secondCommand);
        Assertions.assertThat(result.getDecorated()).isEqualTo(Command.PRIMITIVE_PREFIX + "30");
    }
}
