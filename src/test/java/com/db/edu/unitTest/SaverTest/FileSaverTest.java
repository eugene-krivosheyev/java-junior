package com.db.edu.unitTest.SaverTest;

import com.db.edu.Message.Message;
import com.db.edu.Save.FileSaver;
import com.db.edu.Save.SaveException;
import com.db.edu.Save.Saver;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class FileSaverTest {
    @Test
    public void saveMessageWhenRegularMessageGivenAndDefaultParams() throws SaveException {
        Message messageMock = mock(Message.class);
        when(messageMock.decorate()).thenReturn("Message string with prefix");

        Saver saver = new FileSaver();
        saver.save(messageMock.decorate());

        verify(messageMock, times(1)).decorate();
    }

    @Test
    public void saveMessageWhenRegularMessageGivenAndFileSaverTakesUserParams() throws SaveException {
        Message messageMock = mock(Message.class);
        File fileMock = mock(File.class);
        when(messageMock.decorate()).thenReturn("Message string with prefix");

        Saver saver = new FileSaver(1024, Charset.forName("UTF-8"), fileMock);
        saver.save(messageMock.decorate());

        verify(messageMock, times(1)).decorate();
    }
}
