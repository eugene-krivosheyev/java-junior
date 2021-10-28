package demo;

import java.io.*;
import java.util.Scanner;

public class IoStreamsDemo {
    public static void main(String[] args) {
        try(final BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(
                    new BufferedOutputStream(
                        new FileOutputStream("out.txt")), "windows-1251"))) {

            bufferedWriter.write("HW!!!");
            bufferedWriter.newLine();
            bufferedWriter.write("Превед!!!");
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        final Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

}
