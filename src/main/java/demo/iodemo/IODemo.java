package demo.iodemo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("test.txt"); //Path responsibility

        //Writing:
        try (PrintWriter out =
                     new PrintWriter(
                             new FileWriter(file, true))) {

            out.println("тест 1");
            out.println("тест 2");
            out.println("тест 3");

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Reading:
        try (BufferedReader in = new BufferedReader(
                 new InputStreamReader(
                     new BufferedInputStream(
                         new FileInputStream(file), 8000),
                             "UTF-8"))) {

            String readLine = null;
            while ((readLine = in.readLine()) != null) {
                System.out.println(">>> " + readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // OR with simplified API (≥ v6):
        try {
            //NIO ≥ v6
            Files.lines(Paths.get("test.txt"))
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
