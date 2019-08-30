package com.acme.edu.commands;

import com.acme.edu.commands.ByteCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.IntCommand;
import com.acme.edu.commands.StringCommand;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by kate-c on 28/08/2019.
 */
public class StringCommandTest {

    @Test
    public void shouldDecorateNotAccumulatedCommand() {
        final Command sut = new StringCommand("str");

        assertThat(sut.decorate())
                .isEqualTo("string: str");

    }

    @Test
    public void shouldAcculumateAndDecorateCommandsWithSameMessages() {
        final Command sut = new StringCommand("str");
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(sut, dummySaver);

        assertThat(accumulateResult.decorate())
                .isEqualTo("string: str (x2)");

    }

    @Test
    public void shouldAcculumateCommandsWithDifferentMessages() {
        final Command sut = new StringCommand("str1");
        final Command otherSut = new StringCommand("str2");
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(otherSut, dummySaver);

        assertThat(accumulateResult.decorate())
                .isEqualTo("string: str2");

    }

    @Test @Ignore
    public void shouldFlushCommandsWithDifferentMessages() {
        final Command firstStubCommand = spy(new StringCommand("str1"));

        final Command secondStubCommand = mock(StringCommand.class);

        when(secondStubCommand.getMessage()).thenReturn("str2");
        when(firstStubCommand.isTypeEqual(secondStubCommand)).thenReturn(false);

        final Saver dummySaver = mock(ConsoleSaver.class);
        firstStubCommand.accumulate(secondStubCommand, dummySaver);

        verify(secondStubCommand).getMessage();
        verify(firstStubCommand).isTypeEqual(secondStubCommand);
        verify(firstStubCommand).flush(dummySaver);

    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAccumulateWithNullCommand() {
        final Command sut = new StringCommand("");
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command accumulateResult = sut.accumulate(null, dummySaver);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAccumulateWithOtherTypeCommand() {
        final Command sut = new StringCommand("");
        final Saver dummySaver = mock(ConsoleSaver.class);
        final Command dummyOtherTypeCommand = mock(IntCommand.class);
        final Command accumulateResult = sut.accumulate(dummyOtherTypeCommand, dummySaver);
    }

    @Test
    public void shouldConsiderTwoStringCommandsWithEqualMessagesAsEqualTypesSymmetrically() {
        final Command sut = new StringCommand("");
        final Command otherSut = new StringCommand("");
        final boolean result = sut.isTypeEqual(otherSut);
        final boolean symmetricalResult = otherSut.isTypeEqual(sut);

        assertThat(result).isEqualTo(true);
        assertThat(symmetricalResult).isEqualTo(true);
    }

    @Test
    public void shouldConsiderTwoStringCommandsWithDifferentMessagesAsNotEqualTypesSymmetrically() {
        final Command sut = new StringCommand("str1");
        final Command otherSut = new StringCommand("str2");
        final boolean result = sut.isTypeEqual(otherSut);
        final boolean symmetricalResult = otherSut.isTypeEqual(sut);

        assertThat(result).isEqualTo(false);
        assertThat(symmetricalResult).isEqualTo(false);
    }

    @Test
    public void shouldConsiderTwoCommandsOfDifferentTypesAsNotEqual() {
        final Command sut = new StringCommand("");
        final Command dummyOtherTypeCommand = mock(ByteCommand.class);
        final boolean result = sut.isTypeEqual(dummyOtherTypeCommand);

        assertThat(result).isEqualTo(false);
    }
}
