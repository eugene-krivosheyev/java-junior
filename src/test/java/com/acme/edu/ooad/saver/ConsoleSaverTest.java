package com.acme.edu.ooad.saver;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleSaverTest implements SysoutCaptureAndAssertionAbility {
    Saver saver = new ConsoleSaver();
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
