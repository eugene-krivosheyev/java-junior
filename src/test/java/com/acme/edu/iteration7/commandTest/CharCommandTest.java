package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.CharCommand;
import com.acme.edu.command.Command;
import org.junit.Test;

public class CharCommandTest {
    @Test
    public void shouldntAccumulateWhenTypeChar() {
        Command dummy1 = new CharCommand('a');
        Command dummy2 = new CharCommand('b');
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldGetType() {
        Command dummy1 = new CharCommand('a');
        Type result = dummy1.getType();

        assert result.equals(Type.CHAR);
    }

    @Test
    public void shouldDecorateCharMessageWhenMessageDecorate() {
        Command dummy1 = new CharCommand('a');
        String result = dummy1.messageDecorate();

        assert result.equals("char: a");
    }

    @Test
    public void shouldGetMessage() {
        Command dummy1 = new CharCommand('a');
        char result = ((CharCommand) dummy1).getCharValue();

        assert result == 'a';
    }
}
