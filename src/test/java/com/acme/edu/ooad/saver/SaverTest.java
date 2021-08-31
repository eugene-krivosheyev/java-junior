package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;
import org.junit.jupiter.api.Test;
import com.acme.edu.SysoutCaptureAndAssertionAbility;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaverTest implements SysoutCaptureAndAssertionAbility{
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

    @Test
    public void shouldPrintWhenSaveMessage() {
        resetOut();
        captureSysout();

        Message messageStub = mock(Message.class);
        when(messageStub.getBody()).thenReturn("message to print");
        when(messageStub.toString()).thenReturn("message to print");
        try {
            saver.save(messageStub);
        } catch (SaveException e) {
            e.printStackTrace();
        }
        assertSysoutEquals("message to print"+System.lineSeparator());
    }
}
