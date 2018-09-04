package com.acme.edu.howreadwritetofileswork;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SimultaniousAccessTest {
    private File file;

    @Before
    public void setup() {
        file = new File(".", "hello.txt");
    }
    @Test
    public void shouldReadTheSameFromOneFile() {
        FileInputStream fileInputStream1, fileInputStream2;
        try {
            fileInputStream1 = new FileInputStream(file);
            fileInputStream2 = new FileInputStream(file);

            int read1 = fileInputStream1.read();
            int read2 = fileInputStream2.read();
            assertEquals(read1, read2);
            read1 = fileInputStream1.read();
            read2 = fileInputStream2.read();
            assertEquals(read1, read2);

            fileInputStream1.close();
            fileInputStream2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReadAndWriteSameFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOuputStream = new FileOutputStream(file);

            int read = fileInputStream.read();
            assertEquals(-1, read);
            int write = 'X';
            fileOuputStream.write(write);

            write = 'Y';
            fileOuputStream.write(write);
            read = fileInputStream.read();
            assertEquals('X', read);

            fileInputStream.close();
            fileOuputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldWriteToTheSameFile() {
        try {
            FileOutputStream fileOuputStream1 = new FileOutputStream(file);
            FileOutputStream fileOuputStream2 = new FileOutputStream(file);
            int write1 = 'X';
            int write2 = 'Y';

            fileOuputStream1.write(write1);
            fileOuputStream2.write(write2);
            fileOuputStream2.write(write2);
            fileOuputStream1.write(write1);

            fileOuputStream1.close();
            fileOuputStream2.close();

            FileInputStream fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read();
            assertEquals(write2, read);
            read = fileInputStream.read();
            assertEquals(write1, read);
            fileInputStream.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
