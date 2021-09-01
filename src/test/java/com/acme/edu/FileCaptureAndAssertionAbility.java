package com.acme.edu;

import java.io.*;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface FileCaptureAndAssertionAbility {

    default void assertFileContains(String expected) {
        File source = new File("demo.txt");
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
