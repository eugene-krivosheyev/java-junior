package com.acme.edu.unit;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.IntMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    public void shouldReturnFalseWhenComparingEmptyMessage() {
        EmptyMessage emptyMessage = mock(EmptyMessage.class);
        IntMessage intMessage = mock(IntMessage.class);

        assertFalse(emptyMessage.sameTypeOf(intMessage), "Should return false when comparing empty message");

    }
}