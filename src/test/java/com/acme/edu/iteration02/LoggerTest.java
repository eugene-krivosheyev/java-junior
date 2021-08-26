package com.acme.edu.iteration02;

import com.acme.edu.ooad.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private static final String STRING_PREFIX = "string: ";
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    //region given
    @BeforeEach
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("3");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("Test 1");
        Logger.log(Integer.MIN_VALUE + 1);
        Logger.log(Integer.MAX_VALUE);
        Logger.log(Integer.MIN_VALUE);

        Logger.log("Test 2");
        Logger.log(Integer.MIN_VALUE);
        Logger.log(Integer.MIN_VALUE);
        Logger.log(-42);
        Logger.log(Integer.MAX_VALUE);

        Logger.log("Test 3");
        Logger.log(42);
        for (int i = 0; i < 100; ++i) {
            Logger.log(Integer.MAX_VALUE);
        }
        for (int i = 0; i < 99; ++i) {
            Logger.log(Integer.MIN_VALUE);
        }
        Logger.log(57);

        Logger.log("Test 4");
        Logger.log(Integer.MIN_VALUE / 2);
        Logger.log(Integer.MIN_VALUE / 2);

        Logger.log("Test 5");
        Logger.log(Integer.MAX_VALUE / 2);
        Logger.log(Integer.MAX_VALUE / 2);
        Logger.log(1);

        Logger.log("Test 6");
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            Logger.log(Integer.MIN_VALUE);
            Logger.log(Integer.MAX_VALUE);
        }
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(STRING_PREFIX + "Test 1" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Integer.MIN_VALUE + System.lineSeparator() +
                STRING_PREFIX + "Test 2" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Integer.MIN_VALUE + System.lineSeparator() +
                PRIMITIVE_PREFIX + (-43) + System.lineSeparator() +
                STRING_PREFIX + "Test 3" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Integer.MAX_VALUE + System.lineSeparator() +
                STRING_PREFIX + "Test 4" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Integer.MIN_VALUE + System.lineSeparator() +
                STRING_PREFIX + "Test 5" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Integer.MAX_VALUE + System.lineSeparator() +
                STRING_PREFIX + "Test 6" + System.lineSeparator() +
                PRIMITIVE_PREFIX + (-Integer.MAX_VALUE) + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("Test 1");
        Logger.log((byte) (Byte.MIN_VALUE + 1));
        Logger.log(Byte.MAX_VALUE);
        Logger.log(Byte.MIN_VALUE);

        Logger.log("Test 2");
        Logger.log(Byte.MIN_VALUE);
        Logger.log(Byte.MIN_VALUE);
        Logger.log((byte) -42);
        Logger.log(Byte.MAX_VALUE);

        Logger.log("Test 3");
        Logger.log((byte) 42);
        for (int i = 0; i < 100; ++i) {
            Logger.log(Byte.MAX_VALUE);
        }
        for (int i = 0; i < 99; ++i) {
            Logger.log(Byte.MIN_VALUE);
        }
        Logger.log((byte) 57);

        Logger.log("Test 4");
        Logger.log(Byte.MIN_VALUE / 2);
        Logger.log(Byte.MIN_VALUE / 2);

        Logger.log("Test 5");
        Logger.log(Byte.MAX_VALUE / 2);
        Logger.log(Byte.MAX_VALUE / 2);
        Logger.log(1);

        Logger.log("Test 6");
        for (int i = 0; i < Byte.MAX_VALUE; ++i) {
            Logger.log(Byte.MIN_VALUE);
            Logger.log(Byte.MAX_VALUE);
        }
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(STRING_PREFIX + "Test 1" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Byte.MIN_VALUE + System.lineSeparator() +
                STRING_PREFIX + "Test 2" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Byte.MIN_VALUE + System.lineSeparator() +
                PRIMITIVE_PREFIX + ((byte) -43) + System.lineSeparator() +
                STRING_PREFIX + "Test 3" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Byte.MAX_VALUE + System.lineSeparator() +
                STRING_PREFIX + "Test 4" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Byte.MIN_VALUE + System.lineSeparator() +
                STRING_PREFIX + "Test 5" + System.lineSeparator() +
                PRIMITIVE_PREFIX + Byte.MAX_VALUE + System.lineSeparator() +
                STRING_PREFIX + "Test 6" + System.lineSeparator() +
                PRIMITIVE_PREFIX + ((byte) -Byte.MAX_VALUE) + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("str 2 (x2)");
        assertSysoutContains("0");
        assertSysoutContains("str 2");
        assertSysoutContains("str 3 (x3)");
        //endregion
    }
}