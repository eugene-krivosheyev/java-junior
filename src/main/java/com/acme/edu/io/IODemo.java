package com.acme.edu.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("target", "test.txt");

        try (RandomAccessFile far = new RandomAccessFile(file, "rw")) {

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
