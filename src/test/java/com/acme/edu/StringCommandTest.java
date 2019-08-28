package com.acme.edu;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StringCommandTest {

    @Test
    public void shouldBeEqualToTheSameCommand() {
        final StringCommand sut = new StringCommand("str");
        assertThat(sut.isTypeEquals(sut)).isEqualTo(true);
    }

    @Test
    public void shouldNotBeOverflow() {
        final StringCommand sut = new StringCommand("str");
        assertThat(sut.isOverflow()).isEqualTo(true);
    }

    @Test
    public void shouldBeDecorated() {
        final String STRING_PREFIX = "string: ";
        final StringCommand sut = new StringCommand("str");
        assertThat(sut.getDecorated()).isEqualTo(STRING_PREFIX + "str");
    }
}
