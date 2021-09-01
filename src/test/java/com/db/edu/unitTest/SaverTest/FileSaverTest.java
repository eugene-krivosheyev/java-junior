package com.db.edu.unitTest.SaverTest;

import com.db.edu.Message.Message;
import com.db.edu.Save.FileSaver;
import com.db.edu.Save.SaveException;
import com.db.edu.Save.Saver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class FileSaverTest {
    @Test
    public void saveMessageWhenRegularMessageGivenAndDefaultParams() throws SaveException {
        String expectedString = "Message string with prefix";
        Message messageMock = mock(Message.class);
        when(messageMock.decorate()).thenReturn(expectedString);
        Saver saver = new FileSaver();
        saver.save(messageMock.decorate());

        verify(messageMock, times(1)).decorate();

        String s = readFile("log.txt");
        Assertions.assertEquals(expectedString, s);
    }

    @Test
    public void saveMessageWhenRegularMessageGivenAndFileSaverTakesUserParams() throws SaveException {
        String expectedString = "Message string with prefix";
        Message messageMock = mock(Message.class);
        File fileMock = new File("logTest.txt");
        when(messageMock.decorate()).thenReturn(expectedString);

        Saver saver = new FileSaver(1024, StandardCharsets.UTF_16BE, fileMock);
        saver.save(messageMock.decorate());

        verify(messageMock, times(1)).decorate();
        String s = readFile("log.txt");
        Assertions.assertEquals(expectedString, s);
    }

    private String readFile(String filePath) throws SaveException {
        StringBuilder s = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while (br.ready()){
                s.append(br.readLine());
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            throw new SaveException("File was not found", e);
        }catch (IOException e){
            e.printStackTrace();
            throw new SaveException("IOException", e);
        }
        return s.toString();
    }
}
