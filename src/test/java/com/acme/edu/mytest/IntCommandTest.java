package com.acme.edu.mytest;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.overflow.OverflowException;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class IntCommandTest {

    @Test
    public void shouldAccumulateWithSameCommand() throws OverflowException, IllegalArgumentException {
        final Command sut = new IntCommand(1);
        final Command accumulateResult = sut.accumulate(sut);
        assertThat(accumulateResult.getMessage()).isEqualTo(2);
    }

    @Test
    public void shouldAccumulateWithNewCommand() throws OverflowException, IllegalArgumentException {
        final Command firstSut = new IntCommand(1);
        final Command secondSut = new IntCommand(2);
        final Command accumulateResult = firstSut.accumulate(secondSut);
        assertThat(accumulateResult.getMessage()).isEqualTo(3);
    }

    @Test
    public void shouldDecorateCommand() {
        final Command sut = new IntCommand(1);
        final String decorateResult = sut.decorate();
        assertThat(decorateResult).isEqualTo("primitive: 1");
    }

    @Test(expected = OverflowException.class)
    public void shouldThrowIntegerOverflowException() throws OverflowException, IllegalArgumentException {
        final IntCommand intCommand = new IntCommand(Integer.MAX_VALUE);
        final Command sut = mock(IntCommand.class);
        ((IntCommand) sut).setMessage(10);
        doThrow(OverflowException.class).when(sut).accumulate(intCommand);
        sut.accumulate(intCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfSummIntAndByte() throws OverflowException, IllegalArgumentException {
        final Command sutInt = mock(IntCommand.class);
        ((IntCommand) sutInt).setMessage(1);
        final Command sutByte = mock(ByteCommand.class);
        ((ByteCommand) sutByte).setMessage((byte) 1);
        doThrow(IllegalArgumentException.class).when(sutInt).accumulate(sutByte);
        sutInt.accumulate(sutByte);
    }
}
