package com.acme.edu.ooad.saver;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileSaverTest {
    String filePath = "outputTest.log";
    Saver saver = new FileSaver(/*"US-ASCII"*/"UTF-16",256, filePath,false);

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
