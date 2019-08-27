package com.acme.edu.mytest;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.primitive.BooleanCommand;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BooleanCommandTest {

    @Test
    public void shouldDecorateCommand() {
        final Command sut = new BooleanCommand(false);
        final String decorateResult = sut.decorate();
        assertThat(decorateResult).isEqualTo("primitive: false");
    }
}
