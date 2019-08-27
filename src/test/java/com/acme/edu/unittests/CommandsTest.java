package com.acme.edu.unittests;

import com.acme.edu.commands.CharCommand;
import com.acme.edu.commands.ReferenceCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandsTest {
    @Test
    public void shouldDecorateChar() {
        CharCommand sut = new CharCommand("a");
        assertEquals("char: a", sut.decorate());
    }

    @Test
    public void shouldDecorateReference() {
        ReferenceCommand sut = new ReferenceCommand(String.valueOf(new Object()));
        assertTrue(sut.decorate().contains("@"));
    }
}
