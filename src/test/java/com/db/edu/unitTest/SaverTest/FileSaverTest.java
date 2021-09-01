package com.db.edu.unitTest.SaverTest;

import com.db.edu.Message.Message;
import com.db.edu.Save.FileSaver;
import com.db.edu.Save.SaveException;
import com.db.edu.Save.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class FileSaverTest {
    private final String filename = "logTest.txt";
    private final String expectedString = "Message string with prefix";
    private File file;
    private Saver fileSaver;
    Message messageMock = mock(Message.class);

    @BeforeEach
    void setUp(){
        file = new File(filename);
        fileSaver = new FileSaver(1024, StandardCharsets.UTF_16BE, file);
        when(messageMock.decorate()).thenReturn(expectedString);
    }

    @AfterEach
    void reset(){
        file.delete();
    }

    @Test
    public void saveMessageWhenRegularMessageGivenAndDefaultParams() throws SaveException {
        Saver saver = new FileSaver();
        saver.save(messageMock.decorate());

        verify(messageMock, times(1)).decorate();

        String s = readFile("log.txt", Charset.defaultCharset());
        Assertions.assertEquals(expectedString, s);
    }

    @Test
    public void saveMessageWhenRegularMessageGivenAndFileSaverTakesUserParams() throws SaveException {
        fileSaver.save(messageMock.decorate());

        verify(messageMock, times(1)).decorate();
        String s = readFile(filename, StandardCharsets.UTF_16BE);
        Assertions.assertEquals(expectedString, s);
    }
    @Test
    public void readOnlyFileThrowsSaveException () {
        file.setReadOnly();

        assertThrows(SaveException.class, () -> fileSaver.save(messageMock.decorate()));
    }

    private String readFile(String filePath, Charset charset) throws SaveException {
        StringBuilder s = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(filePath)), charset))){
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
