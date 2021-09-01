package com.db.edu;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.fest.assertions.Assertions.assertThat;

public interface FileCaptureAndAssertionAbility {
    StringBuilder OUT = new StringBuilder();

    default void captureSysout() {
    }

    default void assertSysoutContains(String expected) {
        File source = new File("output.txt");
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(source)), StandardCharsets.UTF_8))) {

            String readLine;
            while((readLine = in.readLine()) != null) {
                OUT.append(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        assertThat(OUT.toString()).contains(expected);
    }

    default void resetOut() {
        File source = new File("output.txt");
        source.delete();
    }

    default void logAssert(String ... args) {
        for (String arg : args) {
            assertSysoutContains(arg);
        }
    }
}
