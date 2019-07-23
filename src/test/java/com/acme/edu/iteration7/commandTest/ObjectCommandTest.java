package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.Command;
import com.acme.edu.command.ObjectCommand;
import org.junit.Test;

public class ObjectCommandTest {
    @Test
    public void shouldntAccumulateWhenTypeObject() {
        Command dummy1 = new ObjectCommand('a');
        Command dummy2 = new ObjectCommand('b');
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldGetType() {
        Command dummy1 = new ObjectCommand('a');
        Type result = dummy1.getType();

        assert result.equals(Type.OBJECT);
    }

    @Test
    public void shouldDecorateObjectMessageWhenMessageDecorate() {
        Command dummy1 = new ObjectCommand('a');
        String result = dummy1.messageDecorate();

        assert result.equals("reference: a");
    }

    @Test
    public void shouldGetMessage() {
        Command dummy1 = new ObjectCommand('a');
        Object result = ((ObjectCommand) dummy1).getObjectValue();

        assert result.equals('a');
    }
}
