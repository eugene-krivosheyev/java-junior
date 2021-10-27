package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.messages.StringMessage;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StringMessageTest {
    @Test
    public void shouldThrowExceptionWhenAccumulateWithAnotherType() {
        // Given
        StringMessage firstMessage = new StringMessage("default str");
        IntMessage anotherTypeMessage = mock(IntMessage.class);

        // Then
        assertThrows(IllegalArgumentException.class,
                () -> firstMessage.accumulate(anotherTypeMessage));
    }
    @Test
    public void shouldReturnPreviousMessageWhenAccumulateDifferentValue() {
        // Given
        StringMessage firstMessage = new StringMessage("default str");
        StringMessage secondMessage = new StringMessage("another str");

        // When
        Message previousMessage = firstMessage.accumulate(secondMessage);

        // Then
        StringMessage expectedMessage = new StringMessage("another str");
        assertEquals(expectedMessage, previousMessage);
    }
}
