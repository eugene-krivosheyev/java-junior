package com.acme.edu.iteration02;

import com.acme.edu.logger.LoggerCore;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerCoreTest implements SysoutCaptureAndAssertionAbility {
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

    // TODO: implement LoggerCore solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        LoggerCore.typeShouldChanged();
        LoggerCore.log("str 1");
        LoggerCore.change();
        LoggerCore.log(1);
        LoggerCore.log(2);
        LoggerCore.change();
        LoggerCore.log("str 2");
        LoggerCore.change();
        LoggerCore.log(0);
        LoggerCore.stop();
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

    /*
    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        LoggerCore.log("str 1");
        LoggerCore.log(10);
        LoggerCore.log(Integer.MAX_VALUE);
        LoggerCore.log("str 2");
        LoggerCore.log(0);
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
        LoggerCore.log("str 1");
        LoggerCore.log((byte)10);
        LoggerCore.log((byte)Byte.MAX_VALUE);
        LoggerCore.log("str 2");
        LoggerCore.log(0);
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
        LoggerCore.log("str 1");
        LoggerCore.log("str 2");
        LoggerCore.log("str 2");
        LoggerCore.log(0);
        LoggerCore.log("str 2");
        LoggerCore.log("str 3");
        LoggerCore.log("str 3");
        LoggerCore.log("str 3");
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
