package com.acme.edu.commands;

import com.acme.edu.commands.ByteCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.IntCommand;
import com.acme.edu.commands.StringCommand;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by kate-c on 28/08/2019.
 */
public class ByteCommandTest {

    @Test
    public void shouldAccumulateWithSameCommandWithoutOverflow() {
        final ByteCommand sut = new ByteCommand((byte)1);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.getMessage())
                .isEqualTo((byte)2);
    }

    @Test
    public void shouldAccumulateWithSameCommandWithUpperOverflow() {
        final Command sut = new ByteCommand((byte)(Byte.MAX_VALUE - 1));
        final Command otherSut = new ByteCommand((byte)2);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.getMessage())
                .isEqualTo((byte)(Byte.MAX_VALUE - 1));
    }

    @Test
    public void shouldAccumulateWithSameCommandWithLowerOverflow() {
        final Command sut = new ByteCommand((byte)(Byte.MIN_VALUE + 1));
        final Command otherSut = new ByteCommand((byte)-2);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.getMessage())
                .isEqualTo((byte)(Byte.MIN_VALUE + 1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAccumulateWithNullCommand() {
        final Command sut = new ByteCommand((byte)0);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(null, dummySaver);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAccumulateWithOtherTypeCommand() {
        final Command sut = new ByteCommand((byte)0);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final StringCommand dummyOtherTypeCommand = mock(StringCommand.class);
        final Command accumulateResult = sut.accumulate(dummyOtherTypeCommand, dummySaver);
    }

    @Test
    public void shouldConsiderTwoIntCommandsAsEqualTypesSymmetrically() {
        final Command sut = new ByteCommand((byte)0);
        final Command otherSut = new ByteCommand((byte)1);
        final boolean result = sut.isTypeEqual(otherSut);
        final boolean symmetricalResult = otherSut.isTypeEqual(sut);

        assertThat(result).isEqualTo(true);
        assertThat(symmetricalResult).isEqualTo(true);
    }

    @Test
    public void shouldConsiderTwoDifferentCommandsAsNotEqual() {
        final Command sut = new ByteCommand((byte)0);
        final StringCommand dummyOtherTypeCommand = mock(StringCommand.class);
        final boolean result = sut.isTypeEqual(dummyOtherTypeCommand);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void shouldDecorateCorrectly() {
        final Command sut = new ByteCommand((byte)1);
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.decorate())
                .isEqualTo("primitive: 2");

    }

}
