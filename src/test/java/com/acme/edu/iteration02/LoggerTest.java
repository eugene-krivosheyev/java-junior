package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    public static final String sep = lineSeparator();
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


//    TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.setSumming(true);
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.log();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + sep +
            "3" + sep +
            "str 2" + sep +
            "0" + sep
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.setSumming(true);
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.log();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + sep +
            "10" + sep +
            Integer.MAX_VALUE + sep +
            "str 2" + sep +
            "0" + sep
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.setSumming(true);
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.log();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + sep +
            "10" + sep +
            Byte.MAX_VALUE + sep +
            "str 2" + sep +
            "0" + sep
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.setSumming(true);
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + sep +
            "str 2 (x2)" + sep +
            "0" + sep +
            "str 2" + sep +
            "str 3 (x3)" + sep
        );
        //endregion
    }
    /*

    */
}