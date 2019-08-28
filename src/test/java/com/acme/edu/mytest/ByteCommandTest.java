package com.acme.edu.mytest;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.overflow.OverflowException;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.SaverException;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ByteCommandTest {

    @Test
    public void shouldAccumulateWithSameCommand() {
        final Command sut = new ByteCommand((byte)1);
        final Command accumulateResult = sut.accumulate(sut);
        assertThat(accumulateResult.getMessage()).isEqualTo((byte)2);
    }

    @Test
    public void shouldAccumulateWithNewCommand() {
        final Command firstSut = new ByteCommand((byte)1);
        final Command secondSut = new ByteCommand((byte)2);
        final Command accumulateResult = firstSut.accumulate(secondSut);
        assertThat(accumulateResult.getMessage()).isEqualTo((byte)3);
    }

    @Test
    public void shouldDecorateCommand() {
        final Command sut = new ByteCommand((byte) 1);
        final String decorateResult = sut.decorate();
        assertThat(decorateResult).isEqualTo("primitive: 1");
    }

    @Test(expected = OverflowException.class)
    public void shouldThrowByteOverflowException() {
        final ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        LoggerController loggerController = new LoggerController(mockSaver);
        final ByteCommand byteCommand = new ByteCommand(Byte.MAX_VALUE);
        final Command sut = mock(ByteCommand.class);
        ((ByteCommand) sut).setMessage((byte) 10);

        loggerController.handleCommand(sut);
        loggerController.handleCommand(byteCommand);
        doThrow(OverflowException.class).when(sut).accumulate(byteCommand);
        sut.accumulate(byteCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfSummByteAndString() {
        final Command sutString = mock(StringCommand.class);
        ((StringCommand) sutString).setMessage("tst 1");
        final Command sutByte = mock(ByteCommand.class);
        ((ByteCommand) sutByte).setMessage((byte) 1);
        doThrow(IllegalArgumentException.class).when(sutByte).accumulate(sutString);
        sutByte.accumulate(sutString);
    }
}
