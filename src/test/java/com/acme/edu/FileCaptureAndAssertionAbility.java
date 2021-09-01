package com.acme.edu;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public interface FileCaptureAndAssertionAbility {

    default void resetFile(String fileName){
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    default void assertFileContains(String expected, String fileName) {
        File source = new File(fileName);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(source)),"windows-1251"))) {

            StringBuilder result = new StringBuilder();
            String readLine;

            while((readLine = in.readLine()) != null) {
                result.append(readLine);
            }

            assertTrue(result.toString().contains(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
