package com.acme.edu.io;

import java.io.*;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("target", "test.txt");

        try (
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        ) {

            bw.write("тестовая строка");
            bw.newLine();
            bw.write("test string");

        } catch (IOException e) {

        }


        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    new BufferedInputStream(
                            new FileInputStream(file)), "UTF-8"))
        ) {

            String in = null;
            while ((in = reader.readLine()) != null) {
                System.out.println(">>>> " + in);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
