package com.acme.edu.commands;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.IntCommand;
import com.acme.edu.commands.StringCommand;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kate-c on 27/08/2019.
 */
public class IntCommandTest {

    @Test
    public void shouldAccumulateWithSameCommandWithoutOverflow() {
        final IntCommand sut = new IntCommand(1);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.getMessage())
                .isEqualTo(2);
    }

    @Test
    public void shouldAccumulateWithSameCommandWithUpperOverflow() {
        final Command sut = new IntCommand(Integer.MAX_VALUE - 1);
        final Command otherSut = new IntCommand(2);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.getMessage())
                .isEqualTo(Integer.MAX_VALUE - 1);
    }

    @Test
    public void shouldAccumulateWithSameCommandWithLowerOverflow() {
        final Command sut = new IntCommand(Integer.MIN_VALUE + 1);
        final Command otherSut = new IntCommand(-2);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.getMessage())
                .isEqualTo(Integer.MIN_VALUE + 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAccumulateWithNullCommand() {
        final Command sut = new IntCommand(0);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(null, dummySaver);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAccumulateWithOtherTypeCommand() {
        final Command sut = new IntCommand(0);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final StringCommand dummyOtherTypeCommand = mock(StringCommand.class);
        final Command accumulateResult = sut.accumulate(dummyOtherTypeCommand, dummySaver);
    }

    @Test
    public void shouldConsiderTwoIntCommandsAsEqualTypesSymmetrically() {
        final Command sut = new IntCommand(0);
        final Command otherSut = new IntCommand(1);
        final boolean result = sut.isTypeEqual(otherSut);
        final boolean symmetricalResult = otherSut.isTypeEqual(sut);

        assertThat(result).isEqualTo(true);
        assertThat(symmetricalResult).isEqualTo(true);
    }

    @Test
    public void shouldConsiderTwoDifferentCommandsAsNotEqual() {
        final Command sut = new IntCommand(0);
        final StringCommand dummyOtherTypeCommand = mock(StringCommand.class);
        final boolean result = sut.isTypeEqual(dummyOtherTypeCommand);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void shouldDecorateCorrectly() {
        final Command sut = new IntCommand(1);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.decorate())
                    .isEqualTo("primitive: 2");

    }

}
