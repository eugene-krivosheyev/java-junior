package com.acme.edu.io;

import java.io.*;

public class IODemo {
    public static void main(String[] args) {
        File f = new File("test.txt"); //NIO2 -> Path
        File f2 = new File(f, "test2");

//        Scanner;

        File file = new File("unicode.txt");

        try (FileWriter fw = new FileWriter(file,true)) {
            fw.write("Привет!!!!");
            fw.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader fr =
                     new BufferedReader(new FileReader(file))) {

            String line = null;
            while((line = fr.readLine()) != null) {
                System.out.println(">>> " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
