package com.acme.edu.mylogger;

import com.acme.edu.mylogger.commands.CharCommand;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CharCommandTest {

    @Test
    public void shouldBeEqualToTheSameCommand() {
        final CharCommand sut = new CharCommand('a');
        assertThat(sut.isTypeEquals(sut)).isEqualTo(false);
    }

    @Test
    public void shouldNotBeOverflow() {
        final CharCommand sut = new CharCommand('a');
        assertThat(sut.isOverflow()).isEqualTo(false);
    }

    @Test
    public void shouldBeDecorated() {
        final String CHAR_PREFIX = "char: ";
        final CharCommand sut = new CharCommand('a');
        assertThat(sut.getDecorated()).isEqualTo(CHAR_PREFIX + 'a');
    }

    @Test
    public void shouldReturnMessage() {
        final CharCommand sut = new CharCommand('a');
        assertThat(sut.getMessage()).isEqualTo('a');
    }

    @Test
    public void shouldNotBeAccumulated() {
        final CharCommand sut = new CharCommand('a');
        assertThat(sut.accumulate(sut)).isEqualTo(sut);
    }
}
