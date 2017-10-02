package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
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
    TODO: implement LoggerController solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        LoggerController.log("str 1");
        LoggerController.log(1);
        LoggerController.log(2);
        LoggerController.log("str 2");
        LoggerController.log(0);
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
        LoggerController.log("str 1");
        LoggerController.log(10);
        LoggerController.log(Integer.MAX_VALUE);
        LoggerController.log("str 2");
        LoggerController.log(0);
        //endregion

        //region then
        assertSysoutContains(
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
        LoggerController.log("str 1");
        LoggerController.log((byte)10);
        LoggerController.log((byte)Byte.MAX_VALUE);
        LoggerController.log("str 2");
        LoggerController.log(0);
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
        LoggerController.log("str 1");
        LoggerController.log("str 2");
        LoggerController.log("str 2");
        LoggerController.log(0);
        LoggerController.log("str 2");
        LoggerController.log("str 3");
        LoggerController.log("str 3");
        LoggerController.log("str 3");
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