package com.acme.edu.io;

import java.io.*;

public class IODemo {
    public static void main(String[] args) {
        File f = new File("test.txt"); //NIO2 -> Path
        File f2 = new File(f, "test2");

//        Scanner;

        File file = new File("unicode.txt");

        try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                    new BufferedOutputStream(
                        new FileOutputStream(file, true)), "windows-1251"))) {

            out.println("Привет!!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    new BufferedInputStream(
                        new FileInputStream(file)), "windows-1251"))) {

            String line = null;
            while((line = in.readLine()) != null) {
                System.out.println(" >>>>>>> " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
