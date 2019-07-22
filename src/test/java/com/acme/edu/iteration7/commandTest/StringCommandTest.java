package com.acme.edu.iteration7.commandTest;

import com.acme.edu.command.ByteCommand;
import com.acme.edu.command.Command;
import com.acme.edu.command.StringCommand;
import org.junit.Test;

public class StringCommandTest {
    @Test
    public void shouldCorrectAccumulateWhenEqualsStrings() {
        Command dummy1 = new StringCommand("string abc");
        Command dummy2 = new StringCommand("string abc");
        boolean result = dummy1.accumulate(dummy2);

        assert result;
    }

    @Test
    public void shouldntAccumulateWhenDifferentStrings() {
        Command dummy1 = new StringCommand("string abc");
        Command dummy2 = new StringCommand("string cba");
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldntAccumulateWhenDifferentTypes() {
        Command dummy1 = new StringCommand("string abc");
        Command dummy2 = new ByteCommand((byte) -10);
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldDecorateStringMessageWhenRepeatString() {
        Command dummy1 = new StringCommand("string abc");
        Command dummy2 = new StringCommand("string abc");
        dummy1.accumulate(dummy2);

        String result = dummy1.messageDecorate();

        assert result.equals("string abc (x2)");
    }

    @Test
    public void shouldDecorateStringMessageWhenSingleString() {
        Command stringCommand = new StringCommand("string abc");
        String result = stringCommand.messageDecorate();

        assert result.equals("string abc");
    }
}
