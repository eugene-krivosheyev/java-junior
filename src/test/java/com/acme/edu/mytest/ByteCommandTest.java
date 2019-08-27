package com.acme.edu.mytest;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.primitive.ByteCommand;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

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
}
