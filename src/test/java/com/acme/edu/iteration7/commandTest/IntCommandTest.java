package com.acme.edu.iteration7.commandTest;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.command.ByteCommand;
import com.acme.edu.command.Command;
import com.acme.edu.command.IntCommand;
import org.junit.Test;


public class IntCommandTest implements SysoutCaptureAndAssertionAbility {
    @Test
    public void shouldCorrectAccumulateWhenAccumulatePositiveWithoutOverflow() {
        Command dummy1 = new IntCommand(10);
        Command dummy2 = new IntCommand(10);
        boolean result = dummy1.accumulate(dummy2);

        assert result;
    }

    @Test
    public void shouldntAccumulateWhenPositiveOverflow() {
        Command dummy1 = new IntCommand(10);
        Command dummy2 = new IntCommand(Integer.MAX_VALUE);
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldntAccumulateWhenNegativeOverflow() {
        Command dummy1 = new IntCommand(-10);
        Command dummy2 = new IntCommand(Integer.MIN_VALUE);
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldCorrectAccumulateWhenAccumulateNegativeWithoutOverflow() {
        Command dummy1 = new IntCommand(-10);
        Command dummy2 = new IntCommand(-10);
        boolean result = dummy1.accumulate(dummy2);

        assert result;
    }

    @Test
    public void shouldntAccumulateWhenDifferentTypes() {
        Command dummy1 = new IntCommand(-10);
        Command dummy2 = new ByteCommand((byte) -10);
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldDecorateIntMessageWhenMessageDecorate() {
        Command intCommand = new IntCommand(10);
        String result = intCommand.messageDecorate();

        assert result.equals("10");
    }
}
