package com.acme.edu.iteration02;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    /*
    TODO: implement TypeSafeLogger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        TypeSafeLogger.log("str 1");
        TypeSafeLogger.log(1);
        TypeSafeLogger.log(2);
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "3\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        TypeSafeLogger.log("str 1");
        TypeSafeLogger.log(10);
        TypeSafeLogger.log(Integer.MAX_VALUE);
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "10\n" +
            Integer.MAX_VALUE + "\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        TypeSafeLogger.log("str 1");
        TypeSafeLogger.log((byte)10);
        TypeSafeLogger.log((byte)Byte.MAX_VALUE);
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "10\n" +
            Byte.MAX_VALUE + "\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        TypeSafeLogger.log("str 1");
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log(0);
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log("str 3");
        TypeSafeLogger.log("str 3");
        TypeSafeLogger.log("str 3");
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)\n"
        );
        //endregion
    }

    */
}