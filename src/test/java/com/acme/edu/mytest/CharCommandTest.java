package com.acme.edu.mytest;

import com.acme.edu.commands.Command;

import com.acme.edu.commands.types.CharCommand;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CharCommandTest {

    @Test
    public void shouldDecorateCommand() {
        final Command sut = new CharCommand('a');
        final String decorateResult = sut.decorate();
        assertThat(decorateResult).isEqualTo("char: a");
    }
}