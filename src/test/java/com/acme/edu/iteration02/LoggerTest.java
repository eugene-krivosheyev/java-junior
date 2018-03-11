package com.acme.edu.iteration02;

import com.acme.edu.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

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
        LoggerFacade.log("str 1");
        LoggerFacade.log(1);
        LoggerFacade.log(2);
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("str 1"+lineSeparator());
        assertSysoutContains("3"+lineSeparator());
        assertSysoutContains("str 2"+lineSeparator());
        assertSysoutContains("0"+lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log(10);
        LoggerFacade.log(Integer.MAX_VALUE);
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("str 1"+lineSeparator());
        assertSysoutContains("10"+lineSeparator());
        assertSysoutContains(Integer.MAX_VALUE+lineSeparator());
        assertSysoutContains("str 2"+lineSeparator());
        assertSysoutContains("0"+lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log((byte)10);
        LoggerFacade.log((byte)Byte.MAX_VALUE);
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("str 1"+lineSeparator());
        assertSysoutContains("10"+lineSeparator());
        assertSysoutContains(Byte.MAX_VALUE+lineSeparator());
        assertSysoutContains("str 2"+lineSeparator());
        assertSysoutContains("0"+lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log("str 2");
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.log("str 2");
        LoggerFacade.log("str 3");
        LoggerFacade.log("str 3");
        LoggerFacade.log("str 3");
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("str 1"+lineSeparator());
        assertSysoutContains("str 2 (x2)"+lineSeparator());
        assertSysoutContains("0"+lineSeparator());
        assertSysoutContains("str 2"+lineSeparator());
        assertSysoutContains("str 3 (x3)"+lineSeparator());
        //endregion
    }
}