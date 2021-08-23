package com.db.edu.iteration2;


import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.edu.Logger.PRIMITIVE_PREFIX;
import static com.db.edu.Logger.STRING_PREFIX;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    @BeforeEach
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }


    @Test
    public void shouldLogSequentIntegersAsSum() {
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();

        logAssert(STRING_PREFIX + "str 1",
                PRIMITIVE_PREFIX + "3",
                STRING_PREFIX + "str 2",
                PRIMITIVE_PREFIX + "0");
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE - 1);
        Logger.log("str 2");
        Logger.log(Integer.MIN_VALUE + 1);
        Logger.log(-10);
        Logger.flush();

        logAssert(STRING_PREFIX + "str 1",
                PRIMITIVE_PREFIX + "9",
                PRIMITIVE_PREFIX + Integer.MAX_VALUE,
                STRING_PREFIX + "str 2",
                PRIMITIVE_PREFIX + Integer.MIN_VALUE,
                PRIMITIVE_PREFIX + "-9");
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        Logger.log("str 1");
        Logger.log((byte) 10);
        Logger.log((byte) (Byte.MAX_VALUE - 1));
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();

        logAssert(STRING_PREFIX + "str 1",
                PRIMITIVE_PREFIX + "9",
                PRIMITIVE_PREFIX + Byte.MAX_VALUE,
                STRING_PREFIX + "str 2",
                PRIMITIVE_PREFIX + "0");
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() {
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.flush();

        logAssert(STRING_PREFIX + "str 1",
                STRING_PREFIX + "str 2 (x2)",
                PRIMITIVE_PREFIX + "0",
                STRING_PREFIX + "str 2",
                STRING_PREFIX + "str 3 (x3)");
    }
}