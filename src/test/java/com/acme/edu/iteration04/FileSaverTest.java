package com.acme.edu.iteration04;

import com.acme.edu.exception.SaveException;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.MatrixMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.FileSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class FileSaverTest {
    @Before
    public void cleanFile() {
        File file = new File(".", "output.txt");
        file.delete();
    }

    @Test
    public void shouldWriteOneCorrectStringToFileWhenWriteOneMessageByFileSaver() throws SaveException {
        FileSaver fileSaver = new FileSaver();
        Message message = new IntMessage(9);
        fileSaver.save(message);
        File file = new File(".", "output.txt");
        //region Byte input
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(file)
                        )
                ))
        )
        {
            String readLine = bufferedReader.readLine();
            assertEquals("9", readLine);
        } catch (IOException e) {
            throw new SaveException(e);
        }
    }

    @Test
    public void shouldWriteSeveralCorrectStringsWhenWriteSeveralMessagesByFileSaver() throws SaveException {
        FileSaver fileSaver = new FileSaver();
        Message message = new StringMessage("1: Hello, World!");
        fileSaver.save(message);
        message = new StringMessage("2: Hello, World!");
        fileSaver.save(message);
        File file = new File(".", "output.txt");
        //region Byte input
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(file)
                        )
                ))
        )
        {
            String readLine;
            int currentLineNumber = 0;
            while ((readLine = bufferedReader.readLine()) != null) {
                if (currentLineNumber == 0) {
                    assertEquals("1: Hello, World!", readLine);
                }
                if (currentLineNumber == 1) {
                    assertEquals("2: Hello, World!", readLine);
                }
                ++currentLineNumber;
            }
        } catch (IOException e) {
            throw new SaveException(e);
        }
    }
}
