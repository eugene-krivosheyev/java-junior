package com.acme.edu.mytest;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.overflow.OverflowException;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class StringCommandTest {

    @Test
    public void shouldAccumulateWithSameCommand() throws OverflowException, IllegalArgumentException {
        final Command sut = new StringCommand("str 1");
        final Command accumulateResult = sut.accumulate(sut);
        assertThat(accumulateResult.getMessage()).isEqualTo("str 1 (x2)");
    }

    @Test
    public void shouldAccumulateWithNewCommand() throws OverflowException, IllegalArgumentException {
        final Command firstSut = new StringCommand("str 1");
        final Command secondSut = new StringCommand("str 2");
        assertThat(firstSut.getMessage()).isEqualTo("str 1");
        final Command accumulateResult = firstSut.accumulate(secondSut);
        assertThat(accumulateResult.getMessage()).isEqualTo("str 2");
    }

    @Test
    public void shouldDecorateCommand() {
        final Command sut = new StringCommand("str 1");
        final String decorateResult = sut.decorate();
        assertThat(decorateResult).isEqualTo("string: str 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfSumStringAndByte() throws IllegalArgumentException, OverflowException {
        final Command sutString = mock(StringCommand.class);
        ((StringCommand) sutString).setMessage("tst 1");
        final Command sutByte = mock(ByteCommand.class);
        ((ByteCommand) sutByte).setMessage((byte) 1);
        doThrow(IllegalArgumentException.class).when(sutString).accumulate(sutByte);
        sutString.accumulate(sutByte);
    }
}
