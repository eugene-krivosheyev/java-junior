package com.acme.edu.unittests;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.IntMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class IntMessageTest {
    @Test
    public void shouldCheckOverFlow() {
        IntMessage message = new IntMessage(12);
        IntMessage message2 = new IntMessage(Integer.MAX_VALUE);

        boolean actualValue = message.isOverFlow(message2);

        assertThat(actualValue).isEqualTo(true);
    }

    @Test
    public void shouldIncreasedAccumulator() {
        IntMessage message = new IntMessage(12);
        IntMessage message1 = new IntMessage(13);

        message1.updateAccumulator(message);

        assertThat(message1.getValue()).isEqualTo(25);
    }

    @Test
    public void shouldReturnCorrectResultToString() {
        IntMessage message = new IntMessage(12);
        String actualStr = message.toString();

        assertThat(actualStr).isEqualTo("primitive: 12");
    }
}
