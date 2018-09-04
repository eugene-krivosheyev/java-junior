package com.acme.edu.moduletests;

import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.SavingException;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileSaverTest {

    @Test(expected = SavingException.class)
    public void shouldThrowExceptionWhenNoSuchDirectory() throws SavingException{
        String strToSave = "Hello, world!";
        String fileName = "hello.txt";
        String parent = "_=0-2=";
        FileSaver fileSaver = new FileSaver(parent, fileName, true, "UTF-16");
        fileSaver.save(strToSave);
    }

    @Test
    public void shouldSaveToFile() throws SavingException{
        String strToSave = "Hello, world!";
        String parent = ".";
        String charset = "UTF-16";
        String fileName = "hello.txt";
        FileSaver fileSaver = new FileSaver(parent, fileName, false, charset);
        fileSaver.save(strToSave);

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(
                                        new File(parent, fileName)
                                )),
                        charset))) {
            String readLine = bufferedReader.readLine();
            assertEquals(strToSave, readLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldSaveMultipleStringsToFile() throws SavingException{
        String[] strToSave = new String[]{"Hello, world!", "string2", "another string", "etc"};
        String parent = ".";
        String charset = "windows-1251";
        String fileName = "hello.txt";
        FileSaver fileSaver = new FileSaver(parent, fileName, false, charset);
        for (int i=0; i<strToSave.length; i++) {
            fileSaver.save(strToSave[i]);
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(
                                        new File(parent, fileName)
                                )),
                        charset))) {
            String readLine = null;
            int i = 0;
            while ((readLine = bufferedReader.readLine()) != null) {
                assertTrue(i < strToSave.length);
                assertEquals(strToSave[i], readLine);
                i++;
            }
            assertTrue(i == strToSave.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
