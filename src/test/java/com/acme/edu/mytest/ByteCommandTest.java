package com.acme.edu.mytest;

import com.acme.edu.commands.ByteCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.IntCommand;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class ByteCommandTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenIntegerOverflowWhileAccumulating() {
        ByteCommand firstCommand = new ByteCommand((byte) 10);
        ByteCommand secondCommand = new ByteCommand(Byte.MAX_VALUE);

        firstCommand.accumulate(secondCommand).getDecorated();

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenTryingToAccumulateWithOtherType() {
        ByteCommand firstCommand = new ByteCommand((byte) 10);
        IntCommand secondCommand = new IntCommand(10);

        firstCommand.accumulate(secondCommand);
    }

    @Test
    public void shouldReturnFalseWhenCallingIsTypeEqualsWithAnotherType() {
        ByteCommand firstCommand = new ByteCommand((byte) 10);
        IntCommand secondCommand = new IntCommand(10);

        Assertions.assertThat(firstCommand.isTypeEquals(secondCommand)).isEqualTo(false);
    }

    @Test
    public void shouldReturnTrueWhenCallingIsTypeEqualsWithSameType() {
        ByteCommand firstCommand = new ByteCommand((byte) 10);
        ByteCommand secondCommand = new ByteCommand((byte) 10);

        Assertions.assertThat(firstCommand.isTypeEquals(secondCommand)).isEqualTo(true);
    }

    @Test
    public void shouldBeDecoratedCorrectly() {
        ByteCommand command = new ByteCommand((byte) 10);

        Assertions.assertThat(command.getDecorated()).isEqualTo(Command.PRIMITIVE_PREFIX + "10");
    }

    @Test
    public void shouldAccumulateReturnMessageIfNotException() {
        ByteCommand firstCommand = new ByteCommand((byte) 10);
        ByteCommand secondCommand = new ByteCommand((byte) 20);

        ByteCommand result = firstCommand.accumulate(secondCommand);
        Assertions.assertThat(result.getDecorated()).isEqualTo(Command.PRIMITIVE_PREFIX + "30");
    }
}
