package com.db.edu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;

public interface SysoutCaptureAndAssertionAbility {
    ByteArrayOutputStream OUT = new ByteArrayOutputStream();

    default void captureSysout() {
        System.setOut(new PrintStream(OUT));
    }

    default void assertSysoutEquals(String expected) {
        assertThat("Actual: " + OUT + " expected: " + expected, OUT.toString().equals(expected));
    }

    default void assertSysoutContains(String expected) {
        assertThat("Actual: " + OUT + " does not contains: " + expected, OUT.toString().contains(expected));
    }

    default void resetOut() {
        OUT.reset();
    }
}