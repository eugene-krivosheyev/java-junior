package com.acme.edu.mytest;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.StringCommand;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StringCommandTest {

    @Test
    public void shouldAccumulateWithSameCommand() {
        final Command sut = new StringCommand("str 1");
        final Command accumulateResult = sut.accumulate(sut);
        assertThat(accumulateResult.getMessage()).isEqualTo("str 1 (x2)");
    }

    @Test
    public void shouldAccumulateWithNewCommand() {
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
}
