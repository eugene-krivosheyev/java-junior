package com.acme.edu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public interface SysoutCaptureAndAssertionAbility {
    ByteArrayOutputStream OUT = new ByteArrayOutputStream();

    default void captureSysout() {
        System.setOut(new PrintStream(OUT));
    }

    default void assertSysoutEquals(String expected) {
        assertTrue(OUT.toString().equals(expected));
    }

    default void assertSysoutContains(String expected) {
        assertThat(OUT.toString(), OUT.toString().contains(expected));
    }

    default void resetOut() {
        OUT.reset();
    }
}
