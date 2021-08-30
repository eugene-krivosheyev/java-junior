package com.acme.edu.unit;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

public class MessageTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @BeforeEach
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldReturnFalseWhenComparingDifferentMessages() {
        EmptyMessage emptyMessage = new EmptyMessage();
        IntMessage intMessage = new IntMessage(anyInt());

        assertFalse(emptyMessage.sameTypeOf(intMessage));

    }

    @Test
    public void shouldReturnTrueWhenComparingIntMessages() {
        IntMessage accumulator = new IntMessage(anyInt());
        IntMessage intMessage = new IntMessage(anyInt());

        assertTrue(accumulator.sameTypeOf(intMessage));
    }

    @Test
    public void shouldReturnTrueWhenComparingStringMessagesWithEqualBodies() {
        String messageBody = anyString();

        StringMessage accumulator = new StringMessage(messageBody);
        StringMessage stringMessage = new StringMessage(messageBody);

        assertTrue(accumulator.sameTypeOf(stringMessage));
    }

    @Test
    public void shouldReturnTrueWhenComparingStringMessagesWithNonEqualBodies() {
        String messageBody = anyString();
        String accumulatorBody = anyString() + ".";

        StringMessage accumulator = new StringMessage(accumulatorBody);
        StringMessage stringMessage = new StringMessage(messageBody);

        assertFalse(accumulator.sameTypeOf(stringMessage));
    }

    @Test
    public void shouldThrowExceptionWhenDifferentMessagesAccumulated() {
        Message accumulator = new IntMessage(anyInt());
        Message stringMessage = new StringMessage(anyString());

        assertThrows(ClassCastException.class, () -> accumulator.accumulate(stringMessage));

    }

    @Test
    public void shouldThrowExceptionWhenNullMessageAccumulated() {
        Message accumulator = new IntMessage(anyInt());

        assertThrows(NullPointerException.class, () -> accumulator.accumulate(null));

    }
}