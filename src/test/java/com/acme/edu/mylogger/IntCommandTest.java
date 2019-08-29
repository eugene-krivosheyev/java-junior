package com.acme.edu.mylogger;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class IntCommandTest {
    @Test
    public void shouldAccumulateWithSameCommand() {
        final IntCommand sut = new IntCommand(1);
        final IntCommand accumulateResult = (IntCommand) sut.accumulate(sut);
        assertThat(accumulateResult.getMessage()).isEqualTo(2);
    }

    @Test
    public void shouldBeEqualToTheSameCommand() {
        final IntCommand sut = new IntCommand(1);
        assertThat(sut.isTypeEquals(sut)).isEqualTo(true);
    }

    @Test
    public void shouldBeGreaterThanZero() {
        final IntCommand sut = new IntCommand(1);
        assertThat(sut.isOverflow()).isEqualTo(false);
    }

    @Test
    public void shouldBeOverflow() {
        final IntCommand sut1 = new IntCommand(-1);
        final IntCommand sut2 = new IntCommand(1);
        final IntCommand sut3 = new IntCommand(Integer.MAX_VALUE);
        assertThat(sut1.isOverflow()).isEqualTo(true);
        assertThat(sut2.accumulate(sut3).isOverflow()).isEqualTo(true);
    }

    @Test
    public void shouldBeDecorated() {
        final String PRIMITIVE_PREFIX = "primitive: ";
        final IntCommand sut = new IntCommand(1);
        assertThat(sut.getDecorated()).isEqualTo(PRIMITIVE_PREFIX + 1);
    }
}
