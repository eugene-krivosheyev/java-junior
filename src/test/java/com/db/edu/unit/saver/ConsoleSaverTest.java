package com.db.edu.unit.saver;

import com.db.edu.SaverException;
import com.db.edu.message.Message;
import com.db.edu.save.ConsoleSaver;
import com.db.edu.save.Saver;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

public class ConsoleSaverTest {

    @Test
    public void weCanSaveMessageUsingConsoleMessage() throws SaverException {
        Message messageMock = mock(Message.class);
        when(messageMock.decorated()).thenReturn("Hello, its decorated string!");

        Saver saver = new ConsoleSaver();
        saver.save(messageMock.decorated());

        verify(messageMock, times(1)).decorated();
    }
}
