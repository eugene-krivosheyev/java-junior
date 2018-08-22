package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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



    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.digitFlush();
        Logger.log("str 2");
        Logger.log(0);
        Logger.digitFlush();
        //endregion

        //region then
        assertSysoutContains("3");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.digitFlush();
        Logger.log(Integer.MAX_VALUE);
        Logger.digitFlush();
        Logger.log("str 2");
        Logger.log(0);
        Logger.digitFlush();
        //endregion

        //region then
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE));
        assertSysoutContains("0");

        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.digitFlush();
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.digitFlush();
        Logger.log("str 2");
        Logger.log(0);
        Logger.digitFlush();
        //endregion

        //region then
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Byte.MAX_VALUE));
        assertSysoutContains("0");

        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.stringFlush();
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.stringFlush();
        Logger.log(0);
        Logger.digitFlush();
        Logger.log("str 2");
        Logger.stringFlush();
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.stringFlush();
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