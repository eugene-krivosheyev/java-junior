package com.db.edu.unit.saver;

import com.db.edu.message.Message;
import com.db.edu.save.FileSaver;
import com.db.edu.save.Saver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileSaverTest {

    private final String fileName = "data.txt";
    File source = new File(fileName);
    Message messageMock = mock(Message.class);
    Saver saver = new FileSaver();

    @Test
    public void weCanSaveMessageToFileCorrectly() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(source)), "windows-1250"));

        when(messageMock.decorated()).thenReturn("Hello");

        saver.save(messageMock.decorated());

        Assertions.assertEquals("Hello", in.readLine());
    }
}
