package com.acme.edu.mytest;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.ReferenceCommand;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ReferenceCommandTest {

    @Test
    public void shouldDecorateCommand() {
        Object object = new Object();
        final Command sut = new ReferenceCommand(object);
        final String decorateResult = sut.decorate();
        assertThat(decorateResult).isEqualTo("reference: " + object.toString());
    }
}
