package com.acme.edu.unit;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest implements SysoutCaptureAndAssertionAbility {
    private final String DEFAULT_STRING = "default";
    private final int DEFAULT_INT = 1;

    private EmptyMessage emptyMessage;
    private IntMessage intMessage;
    private StringMessage stringMessage;

    //region given
    @BeforeEach
    public void setUpSystemOut() {
        emptyMessage = new EmptyMessage();
        intMessage = new IntMessage(DEFAULT_INT);
        stringMessage = new StringMessage(DEFAULT_STRING);
    }

    @Test
    public void shouldReturnFalseWhenComparingDifferentMessages() {
        assertFalse(emptyMessage.sameTypeOf(intMessage));
    }

    @Test
    public void shouldReturnTrueWhenComparingIntMessages() {
        IntMessage accumulator = new IntMessage(DEFAULT_INT);

        assertTrue(accumulator.sameTypeOf(intMessage));
    }

    @Test
    public void shouldReturnTrueWhenComparingStringMessagesWithEqualBodies() {
        StringMessage accumulator = new StringMessage(DEFAULT_STRING);

        assertTrue(accumulator.sameTypeOf(stringMessage));
    }

    @Test
    public void shouldReturnTrueWhenComparingStringMessagesWithNonEqualBodies() {
        StringMessage accumulator = new StringMessage(DEFAULT_STRING + ".");

        assertFalse(accumulator.sameTypeOf(stringMessage));
    }

    @Test
    public void shouldThrowExceptionWhenDifferentMessagesAccumulated() {
        Message accumulator = new IntMessage(DEFAULT_INT);

        assertThrows(ClassCastException.class, () -> accumulator.accumulate(stringMessage));

    }

    @Test
    public void shouldThrowExceptionWhenNullMessageAccumulated() {
        Message accumulator = new IntMessage(DEFAULT_INT);

        assertThrows(NullPointerException.class, () -> accumulator.accumulate(null));

    }
}