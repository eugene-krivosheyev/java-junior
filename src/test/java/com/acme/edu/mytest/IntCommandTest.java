package com.acme.edu.mytest;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.overflow.ControllerOverflow;
import com.acme.edu.overflow.OverflowException;
import com.acme.edu.saver.ConsoleSaver;
import org.junit.Test;
import org.mockito.Mockito;

import static com.acme.edu.overflow.ControllerOverflow.controlOverflow;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntCommandTest {

    @Test
    public void shouldAccumulateWithSameCommand() {
        final Command sut = new IntCommand(1);
        final Command accumulateResult = sut.accumulate(sut);
        assertThat(accumulateResult.getMessage()).isEqualTo(2);
    }

    @Test
    public void shouldAccumulateWithNewCommand() {
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
    public void shouldThrowIntegerOverflowException() {
        final ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        LoggerController loggerController = new LoggerController(mockSaver);
        final IntCommand intCommand = new IntCommand(Integer.MAX_VALUE);
        final Command sut = mock(IntCommand.class);
        ((IntCommand) sut).setMessage(10);

        loggerController.handleCommand(sut);
        loggerController.handleCommand(intCommand);
        doThrow(OverflowException.class).when(sut).accumulate(intCommand);
        sut.accumulate(intCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfSummIntAndByte() {
        final Command sutInt = mock(IntCommand.class);
        ((IntCommand) sutInt).setMessage(1);
        final Command sutByte = mock(ByteCommand.class);
        ((ByteCommand) sutByte).setMessage((byte) 1);
        doThrow(IllegalArgumentException.class).when(sutInt).accumulate(sutByte);
        sutInt.accumulate(sutByte);
    }
}
