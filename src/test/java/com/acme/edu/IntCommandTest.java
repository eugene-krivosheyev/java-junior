package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.exception.IntLogException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

public class IntCommandTest {
    private IntCommand intCommand;

    @Before
    public void setUp() {
        intCommand = new IntCommand(1);
    }

    @Test
    public void shouldReturnTrueWhenNewCommandTypeIsTheSame() {
        assertTrue(intCommand.isSameType(new IntCommand(anyInt())));
    }

    @Test
    public void shouldReturnFalseWhenNewCommandTypeIsNotTheSame() {
        assertFalse(intCommand.isSameType(new StringCommand(anyString())));
    }

    @Test
    public void shouldCreateNewIntCommandWhenAccumulate() throws IntLogException {
        IntCommand newCommand = new IntCommand(1);
        assertThat(intCommand.accumulate(newCommand)).usingRecursiveComparison()
                .isEqualTo(new IntCommand(2));
    }

    @Test
    public void shouldReturnDecoratedCommand(){
        assertEquals("primitive: 1", intCommand.toString());
    }

    @Test(expected = IntLogException.class)
    public void shouldThrowIntLogExceptionWhenOverflow() throws IntLogException{
        IntCommand maxValueIntCommand = new IntCommand(Integer.MAX_VALUE);

        intCommand.accumulate(maxValueIntCommand);
    }

    @Test
    public void shouldThrowIntLogExceptionWithRightMessageWhenOverflow(){
        IntCommand maxValueIntCommand = new IntCommand(Integer.MAX_VALUE);

        try {
            intCommand.accumulate(maxValueIntCommand);
        } catch (IntLogException e) {
            assertEquals("can't accumulate integer cause by overflow", e.getMessage());
        }
    }
}
