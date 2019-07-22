package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.Command;
import com.acme.edu.command.NoneCommand;
import org.junit.Test;

public class NoneCommandTest {
    @Test
    public void shouldntAccumulateWhenTypeNone() {
        Command dummy1 = new NoneCommand();
        Command dummy2 = new NoneCommand();
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldGetType() {
        Command dummy1 = new NoneCommand();
        Type result = dummy1.getType();

        assert result.equals(Type.NONE);
    }

    @Test
    public void shouldDecorateNoneMessageWhenMessageDecorate() {
        Command dummy1 = new NoneCommand();
        String result = dummy1.messageDecorate();

        assert result.equals("None command");
    }
}
