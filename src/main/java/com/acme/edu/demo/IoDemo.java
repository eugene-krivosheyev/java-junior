package com.acme.edu.demo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class IoDemo {
    public static void main(String[] args) {
        File file = new File("text.txt");
        File sub = new File(file, "fff");
        final String separator = File.separator;
        Paths.get("a", "b");

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.writeUTF("HW!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Charset win = Charset.forName("windows-1251");
        try (final PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(
                         new BufferedOutputStream(
                            new FileOutputStream("win-1251.txt", false)), win))) {

            out.println("превед0");
            out.println("превед1");
            out.println("превед2");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (final BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    new BufferedInputStream(
                        new FileInputStream("win-1251.txt"))))) {

            String readLine = null;
            while((readLine = in.readLine()) != null) {
                System.out.println(">>> " + readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            Files.readAllLines(Paths.get("text.txt"))
                    .forEach(l -> System.out.println("<<< " + l));

            Files.lines(Paths.get("text.txt"))
                    .forEach(l -> System.out.println("||| " + l));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
