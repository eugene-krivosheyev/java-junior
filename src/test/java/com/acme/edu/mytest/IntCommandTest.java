package com.acme.edu.mytest;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.primitive.IntCommand;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

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
}
