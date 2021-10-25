package com.acme.edu.practice;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.controller.Controller;
import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ControllerTest implements SysoutCaptureAndAssertionAbility {
    private Saver saver;
    private Message messageStub;
    private Controller controller;

    @BeforeEach
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();

        saver = mock(Saver.class);
        messageStub = mock(Message.class);
        controller = new Controller(saver);
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldNotAppendWhenFirstLog() {
        controller.log(messageStub);
        verify(messageStub, never()).append(any());
    }

    @Test
    public void shouldTryAppendWhenNotFirstLog() {
        when(messageStub.canAppend(any(Message.class))).thenReturn(true);

        controller.log(messageStub);
        controller.log(messageStub);

        verify(messageStub, times(1)).append(messageStub);
        verify(saver, never()).save(any());
    }

    @Test
    public void shouldSaveWhenCouldNotAppend() {
        when(messageStub.canAppend(any(Message.class))).thenReturn(false);

        controller.log(messageStub);
        controller.log(messageStub);

        verify(messageStub, never()).append(any());
        verify(saver, times(1)).save(any());
    }
}
