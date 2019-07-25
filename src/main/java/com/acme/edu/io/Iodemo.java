package com.acme.edu.io;

import java.io.*;
import java.nio.file.Files;

public class Iodemo {
    public static void main(String[] args) throws IOException {
        File path = new File("target", "test.txt");
        path.createNewFile();

        try (RandomAccessFile raf = new RandomAccessFile(path, "rw");) {
            raf.writeUTF("Hello!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            System.out.println(in.readLine());
        }

        path.delete();
        try (final BufferedWriter out
                     = new BufferedWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             new FileOutputStream(
                                                     path), 8_000)))) {

            out.write("превед!");
            out.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Files.readAllLines(path.toPath()).forEach(System.out::println);

    }
}
