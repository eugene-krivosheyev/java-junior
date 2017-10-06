package com.acme.iodemo;

import java.io.*;

public class IoDemo {
    public static void main(String[] args) {
        //Blocking IO vs NIO2: Path
        File path = new File("test.txt");
        path = new File("df/54" + File.separator + "a.txt");
        path = new File("a", "b");
        path = new File("target", "test.txt");

        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        //IO Streams
        try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(path)),
                                "windows-1251"))) {

            out.println("тестовые данные");
            out.println("тестовые данные");
            out.println("тестовые данные");
            out.println("тестовые данные");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
