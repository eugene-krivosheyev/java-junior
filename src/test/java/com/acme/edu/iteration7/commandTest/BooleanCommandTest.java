package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.BooleanCommand;
import com.acme.edu.command.Command;
import org.junit.Test;

public class BooleanCommandTest {

    @Test
    public void shouldntAccumulateWhenTypeBool(){
        Command dummy1 = new BooleanCommand(true);
        Command dummy2 = new BooleanCommand(false);
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldDecorateBoolMessageWhenMessageDecorate(){
        Command dummy1 = new BooleanCommand(true);
        String result = dummy1.messageDecorate();

        assert result.equals("primitive: true");
    }

    @Test
    public void shouldGetMessage(){
        Command dummy1 = new BooleanCommand(true);
        boolean result = ((BooleanCommand) dummy1).getBooleanValue();

        assert result==true;
    }
}
