package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;
import org.junit.jupiter.api.Test;
import com.acme.edu.SysoutCaptureAndAssertionAbility;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaverTest {
    Saver saver = new ConsoleSaver();
    @Test
    public void shouldGetErrorWhenMessageIsNull() {
        Message nullMessage = null;

        assertThrows(
                SaveException.class,
                () -> saver.save(nullMessage)
        );
    }

    @Test
    public void shouldGetErrorWhenMessageIsEmpty() {
        Message emptyMessageStub = mock(Message.class);
        when(emptyMessageStub.getBody()).thenReturn("");

        assertThrows(
                SaveException.class,
                () -> saver.save(emptyMessageStub)
        );
    }
}
