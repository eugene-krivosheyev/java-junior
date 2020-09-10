package com.acme.edu.unittests;

import com.acme.edu.message.IntMessage;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class IntMessageTest {
    @Test
    public void shouldCheckOverFlow() {
        IntMessage message = new IntMessage(12);
        IntMessage message2 = new IntMessage(Integer.MAX_VALUE);

        boolean actualValue = message.needFlush(message2);

        assertThat(actualValue).isEqualTo(true);
    }

    @Test
    public void shouldIncreaseAccumulator() {
        IntMessage message = new IntMessage(12);

        message.updateAccumulator(new IntMessage(13));

        assertThat(message.getValue()).isEqualTo(25);
    }

    @Test
    public void shouldReturnCorrectResultToString() {
        IntMessage message = new IntMessage(12);
        String actualStr = message.toString();

        assertThat(actualStr).isEqualTo("primitive: 12");
    }
}
