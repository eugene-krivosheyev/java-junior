package com.acme.edu.mylogger;

import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StringCommandTest {

    @Test
    public void shouldBeEqualToTheSameCommand() {
        final StringCommand sut = new StringCommand("str");
        assertThat(sut.isTypeEquals(sut)).isEqualTo(true);
    }

    @Test
    public void shouldBeEqualToTheSameString() {
        final StringCommand sut = new StringCommand("str");
        assertThat(sut.isTypeEquals(sut)).isEqualTo(true);
    }

    @Test
    public void shouldNotBeEqualToAnotherString() {
        final StringCommand sut1 = new StringCommand("str 1");
        final StringCommand sut2 = new StringCommand("str 2");
        assertThat(sut1.isTypeEquals(sut2)).isEqualTo(false);
    }

    @Test
    public void shouldNotBeOverflow() {
        final StringCommand sut = new StringCommand("str");
        assertThat(sut.isOverflow()).isEqualTo(false);
    }

    @Test
    public void shouldBeDecoratedWhenRepeatsOnce() {
        final String STRING_PREFIX = "string: ";
        final StringCommand sut = new StringCommand("str");
        assertThat(sut.getDecorated()).isEqualTo(STRING_PREFIX + "str");
    }

    @Test
    public void shouldBeDecoratedWhenRepeatsMoreThanOnce() {
        final String STRING_PREFIX = "string: ";
        final StringCommand sut = new StringCommand("str", 2);
        assertThat(sut.getDecorated()).isEqualTo(STRING_PREFIX + "str x2");
    }
}
