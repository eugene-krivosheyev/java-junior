package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileSaverTest {
    private final String filePath = "outputTest.log";
    private final Saver saver = new FileSaver("UTF-16", 256, filePath, false);

    @Test
    public void shouldSaveMessageToFileWhenSaveMessage() {

        Message messageStub = mock(Message.class);
        String messageBody = "message to print";
        when(messageStub.getBody()).thenReturn(messageBody);
        when(messageStub.toString()).thenReturn(messageBody);
        try {
            saver.save(messageStub);
            Scanner scanner = new Scanner(new File(filePath), StandardCharsets.UTF_16);
            assertEquals(messageBody, scanner.nextLine());
        } catch (SaveException | IOException e) {
            e.printStackTrace();
        }
    }
}
