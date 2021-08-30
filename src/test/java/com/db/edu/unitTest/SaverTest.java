package com.db.edu.unitTest;

import com.db.edu.Message.Message;
import com.db.edu.Save.ConsoleSaver;
import com.db.edu.Save.SaveException;
import com.db.edu.Save.Saver;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SaverTest {
    @Test
    public void weCanSaveMessageUsingConsoleMessage() throws SaveException {
        Message messageMock = mock(Message.class);
        when(messageMock.decorate()).thenReturn("Message string with prefix");

        Saver saver = new ConsoleSaver();
        saver.save(messageMock.decorate());

        verify(messageMock, times(1)).decorate();
    }
}
