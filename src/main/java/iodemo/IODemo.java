package iodemo;

import java.io.*;
import java.util.Locale;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("." + File.separator + "test.txt");

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    new BufferedInputStream(
                        new FileInputStream(file)), "UTF-8"))) {

            String readLine;
            while((readLine = br.readLine()) != null) {
                System.out.println(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
