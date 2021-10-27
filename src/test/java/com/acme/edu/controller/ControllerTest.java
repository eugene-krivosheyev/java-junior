package com.acme.edu.controller;

import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SavingException;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ControllerTest {
    private Saver saver;
    private Message message;
    private Controller controller;

    @BeforeEach
    public void setUp() {
        saver = mock(ConsoleSaver.class);
        message = mock(Message.class);
        controller = new Controller(saver);
    }

    @Test
    public void shouldNotAppendWhenFirstLog() {
        controller.log(message);
        verify(message, never()).append(any());
    }

    @Test
    public void shouldAppendWhenSecondLog() {
        when(message.canAppend(any(Message.class))).thenReturn(true);
        when(message.append(any(Message.class))).thenReturn(new Message[]{message});
        controller.log(message);
        controller.log(message);

        verify(message, times(1)).append(message);
        verify(saver, never()).save(any());
    }

    @Test
    public void shouldLogWhenMessageTypeChanged() {
        when(message.canAppend(any(Message.class))).thenReturn(false);

        controller.log(message);
        controller.log(message);

        verify(message, never()).append(any());
        verify(saver).save(message.getBody());
    }

    @Test
    public void shouldLogMessageWhenAccumulateSameTypeAndTypeChanged() {
        Message sameTypeMessage = mock(Message.class);
        Message anotherTypeMessage = mock(Message.class);

        when(message.canAppend(sameTypeMessage)).thenReturn(true);
        when(message.append((sameTypeMessage))).thenReturn(new Message[]{message});

        when(message.canAppend(anotherTypeMessage)).thenReturn(false);

        controller.log(message);
        controller.log(sameTypeMessage);
        controller.log(anotherTypeMessage);

        verify(saver).save(message.getBody());
    }

    @Test
    public void shouldNotifyWhenCouldNotLog() {
        when(message.getBody()).thenReturn("message");
        doThrow(new SavingException("This Saver can`t save")).when(saver).save(anyString());

        controller.log(message);
        assertThrows(SavingException.class, () -> controller.flush());
    }

    @Test
    public void shouldNotifyWhenReceiveNullMessage() {
        assertThrows(IllegalArgumentException.class, () -> controller.log(null));
    }
}
