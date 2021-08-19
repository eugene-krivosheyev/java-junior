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
                assertThat("Sysout equal: ",OUT.toString().equals(expected));
    }

    default void assertSysoutContains(String expected) {
        assertThat("Sysout contains: ",OUT.toString().contains(expected));
    }

    default void resetOut() {
        OUT.reset();
    }
}