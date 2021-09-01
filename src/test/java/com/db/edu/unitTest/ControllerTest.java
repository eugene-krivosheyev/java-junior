package com.db.edu.unitTest;

import com.db.edu.Save.ConsoleSaver;
import com.db.edu.LoggerController;
import com.db.edu.Message.Message;
import com.db.edu.Message.StringMessage;
import com.db.edu.Save.SaveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControllerTest {
    @Test
    public void notSaveBeforeFlushOrAnotherMessageType() throws SaveException {
        Message message = mock(StringMessage.class);
        ConsoleSaver consoleSaver = mock(ConsoleSaver.class);
        LoggerController loggerController = new LoggerController(consoleSaver);

        loggerController.log(message);
        verify(consoleSaver, times(0)).save(message.decorate());
        assertEquals(message, loggerController.getLastMessage());
    }

    @Test
    public void saveMessageAfterCloseMethod() throws SaveException {
        Message message = mock(StringMessage.class);
        ConsoleSaver consoleSaver = mock(ConsoleSaver.class);
        LoggerController loggerController = new LoggerController(consoleSaver);

        loggerController.log(message);
        loggerController.close();
        verify(consoleSaver, times(1)).save(message.decorate());
        assertNull(loggerController.getLastMessage());
    }

    @Test
    public void notSaveAfterSameTypeMessage() throws SaveException {
        Message message1 = mock(Message.class);
        Message message2 = mock(Message.class);
        ConsoleSaver consoleSaver = mock(ConsoleSaver.class);
        LoggerController loggerController = new LoggerController(consoleSaver);
        when(message2.typeEquals(message1)).thenReturn(true);

        loggerController.log(message1);
        loggerController.log(message2);
        verify(consoleSaver, times(0)).save(anyString());
        assertNotNull(loggerController.getLastMessage());
    }

    @Test
    public void saveAfterAnotherTypeMessage() throws SaveException {
        Message message1 = mock(Message.class);
        Message message2 = mock(Message.class);
        ConsoleSaver consoleSaver = mock(ConsoleSaver.class);
        LoggerController loggerController = new LoggerController(consoleSaver);
        when(message2.typeEquals(message1)).thenReturn(false);

        loggerController.log(message1);
        loggerController.log(message2);
        verify(consoleSaver, times(1)).save(message1.decorate());
        assertNotNull(loggerController.getLastMessage());
    }

    @Test
    public void nullMessageThrowsNullPointerException() {
        Message message = null;
        ConsoleSaver consoleSaver = mock(ConsoleSaver.class);
        LoggerController loggerController = new LoggerController(consoleSaver);

        assertThrows(NullPointerException.class, () -> loggerController.log(message));
    }

    @Test
    public void nullMessageBodyThrowsNullPointerException(){
        Message message = mock(Message.class);
        ConsoleSaver consoleSaver = mock(ConsoleSaver.class);
        LoggerController loggerController = new LoggerController(consoleSaver);
        when(message.getValue()).thenReturn(null);

        assertThrows(NullPointerException.class, () -> loggerController.log(message));
    }
}
