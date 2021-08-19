package com.db.edu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public interface SysoutCaptureAndAssertionAbility {
    ByteArrayOutputStream OUT = new ByteArrayOutputStream();

    static void captureSysout() {
        System.setOut(new PrintStream(OUT));
    }

    default void assertSysoutEquals(String expected) {
        assertThat(OUT.toString(), is(expected));
    }

    default void assertSysoutContains(String expected) {
        assertThat(OUT.toString(), containsString(expected));
    }

    static void resetOut() {
        OUT.reset();
    }
}
