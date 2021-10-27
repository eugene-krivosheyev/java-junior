package com.acme.edu.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OverflowingMessageTest {
    @Test
    public void shouldReturnOverflowAndRemainderMessagesWhenOverflow() {
        OverflowingMessage message = new SingleNumberMessage(Integer.MAX_VALUE, Integer.MIN_VALUE, 10);
        OverflowingMessage secondMessage = mock(SingleNumberMessage.class);

        when(secondMessage.getAccumulator()).thenReturn((long) Integer.MAX_VALUE);
        when(secondMessage.getMaxLimit()).thenReturn((long) Integer.MAX_VALUE);
        when(secondMessage.getMinLimit()).thenReturn((long) Integer.MIN_VALUE);

        Message[] result = message.append(secondMessage);
        assertAll(
                () -> assertEquals(2, result.length),
                () -> assertEquals(SingleNumberMessage.PRIMITIVE_PREFIX + Integer.MAX_VALUE, result[0].getBody()),
                () -> assertEquals(SingleNumberMessage.PRIMITIVE_PREFIX + 10, result[1].getBody())
        );
    }
}
