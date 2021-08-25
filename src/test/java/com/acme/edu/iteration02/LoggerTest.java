package com.acme.edu.iteration02;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.ooad.controller.OldLoggerController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import com.acme.edu.ooad.factory.LoggerControllerFactory;
import static com.acme.edu.OldLogger.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
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

        OldLoggerController logger = LoggerControllerFactory.create();

        //region when
        logger.log("str 1");
        logger.log(1);
        logger.log(2);
        logger.log("str 2");
        logger.log(0);
        logger.flush();
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

        OldLoggerController logger = LoggerControllerFactory.create();

        //region when
        logger.log("Test 1");
        logger.log(Integer.MIN_VALUE + 1);
        logger.log(Integer.MAX_VALUE);
        logger.log(Integer.MIN_VALUE);

        logger.log("Test 2");
        logger.log(Integer.MIN_VALUE);
        logger.log(Integer.MIN_VALUE);
        logger.log(-42);
        logger.log(Integer.MAX_VALUE);

        logger.log("Test 3");
        logger.log(42);
        for (int i = 0; i < 100; ++i) {
            logger.log(Integer.MAX_VALUE);
        }
        for (int i = 0; i < 99; ++i) {
            logger.log(Integer.MIN_VALUE);
        }
        logger.log(57);

        logger.log("Test 4");
        logger.log(Integer.MIN_VALUE / 2);
        logger.log(Integer.MIN_VALUE / 2);

        logger.log("Test 5");
        logger.log(Integer.MAX_VALUE / 2);
        logger.log(Integer.MAX_VALUE / 2);
        logger.log(1);

        logger.log("Test 6");
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            logger.log(Integer.MIN_VALUE);
            logger.log(Integer.MAX_VALUE);
        }
        logger.flush();
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

        OldLoggerController logger = LoggerControllerFactory.create();

        //region when
        logger.log("Test 1");
        logger.log((byte) (Byte.MIN_VALUE + 1));
        logger.log(Byte.MAX_VALUE);
        logger.log(Byte.MIN_VALUE);

        logger.log("Test 2");
        logger.log(Byte.MIN_VALUE);
        logger.log(Byte.MIN_VALUE);
        logger.log((byte) -42);
        logger.log(Byte.MAX_VALUE);

        logger.log("Test 3");
        logger.log((byte) 42);
        for (int i = 0; i < 100; ++i) {
            logger.log(Byte.MAX_VALUE);
        }
        for (int i = 0; i < 99; ++i) {
            logger.log(Byte.MIN_VALUE);
        }
        logger.log((byte) 57);

        logger.log("Test 4");
        logger.log(Byte.MIN_VALUE / 2);
        logger.log(Byte.MIN_VALUE / 2);

        logger.log("Test 5");
        logger.log(Byte.MAX_VALUE / 2);
        logger.log(Byte.MAX_VALUE / 2);
        logger.log(1);

        logger.log("Test 6");
        for (int i = 0; i < Byte.MAX_VALUE; ++i) {
            logger.log(Byte.MIN_VALUE);
            logger.log(Byte.MAX_VALUE);
        }
        logger.flush();
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

        OldLoggerController logger = LoggerControllerFactory.create();

        //region when
        logger.log("str 1");
        logger.log("str 2");
        logger.log("str 2");
        logger.log(0);
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 3");
        logger.log("str 3");
        logger.flush();
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