package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    public String lineSeparator = System.lineSeparator();

    //region given
    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    @Test
    public void shouldLogSequentIntegersAsSum() {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flushBuffers();
        //endregion

        //region then
        assertSysoutContains("str 1" + lineSeparator);
        assertSysoutContains("3" + lineSeparator);
        assertSysoutContains("str 2" + lineSeparator);
        assertSysoutContains("0" + lineSeparator);
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flushBuffers();
        //endregion

        //region then
        assertSysoutContains("str 1" + lineSeparator);
        assertSysoutContains("10" + lineSeparator);
        assertSysoutContains(Integer.MAX_VALUE + lineSeparator);
        assertSysoutContains("str 2" + lineSeparator);
        assertSysoutContains("0" + lineSeparator);
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte) 10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + lineSeparator);
        assertSysoutContains("10" + lineSeparator);
        assertSysoutContains(Byte.MAX_VALUE + lineSeparator);
        assertSysoutContains("str 2" + lineSeparator);
        assertSysoutContains("0" + lineSeparator);
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.flushBuffers();
        //endregion

        //region then
        assertSysoutContains("str 1" + lineSeparator);
        assertSysoutContains("str 2 (x2)" + lineSeparator);
        assertSysoutContains("0" + lineSeparator);
        assertSysoutContains("str 2" + lineSeparator);
        assertSysoutContains("str 3 (x3)" + lineSeparator);
        //endregion
    }

}