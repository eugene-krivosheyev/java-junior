package com.acme.edu.mytest;

import com.acme.edu.commands.IntCommand;
import org.junit.Test;

public class IntCommandTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenIntegerOverflowWhileAccumulating() {
        IntCommand secondCommand = new IntCommand(Integer.MAX_VALUE);
        IntCommand firstCommand = new IntCommand(10);

        firstCommand.accumulate(secondCommand);
    }
}
