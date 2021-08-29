package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaverTest {
    @Test
    public void shouldGetErrorWhenMessageIsNull() {
        Saver saver = new ValidatingSaver();
        Message nullMessage = null;

        assertThrows(
                IllegalArgumentException.class,
                () -> saver.save(nullMessage)
        );
    }

    @Test
    public void shouldGetErrorWhenMessageIsEmpty() {
        Saver saver = new ValidatingSaver();
        Message emptyMessage = mock(Message.class);
        when(emptyMessage.toString()).thenReturn("");
        assertThrows(
                IllegalArgumentException.class,
                () -> saver.save(emptyMessage)
        );
    }
}
