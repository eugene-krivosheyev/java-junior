package com.acme.edu.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Iodemo {
    public static void main(String[] args) throws IOException {
        File path = new File("target", "test.txt");
        path.createNewFile();

        try (RandomAccessFile raf = new RandomAccessFile(path, "w");) {
            raf.writeUTF("Hello!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
