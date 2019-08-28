package com.acme.edu.mytest;

import com.acme.edu.commands.IntCommand;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.mockito.Mockito.*;

public class IntCommandTest {
    private static final String MESSAGE_FIELD = "message";

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenIntegerOverflowWhileAccumulating() {
        IntCommand firstCommand = mock(IntCommand.class);
        IntCommand secondCommand = mock(IntCommand.class);
        Whitebox.setInternalState(firstCommand, MESSAGE_FIELD, 10);
        Whitebox.setInternalState(secondCommand, MESSAGE_FIELD, Integer.MAX_VALUE);

        doThrow(IllegalArgumentException.class).when(firstCommand).accumulate(secondCommand);
        firstCommand.accumulate(secondCommand);
    }
}
