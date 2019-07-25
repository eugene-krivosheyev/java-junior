package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

@Ignore
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

//    TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.deleteLog();
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        String newLine = lineSeparator();
        assertSysoutEquals(
            "str 1" + newLine +
            "3" + newLine +
            "str 2" + newLine +
            "0" + newLine
        );
        //endregion
    }


    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + lineSeparator() +
            "10" + lineSeparator() +
            Integer.MAX_VALUE + lineSeparator() +
            "str 2" + lineSeparator() +
            "0" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + lineSeparator() +
            "10" + lineSeparator() +
            Byte.MAX_VALUE + lineSeparator() +
            "str 2" + lineSeparator() +
            "0" + lineSeparator()
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
        assertSysoutEquals(
            "str 1" + lineSeparator() +
            "str 2 (x2)" + lineSeparator() +
            "0" + lineSeparator() +
            "str 2" + lineSeparator() +
            "str 3 (x3)" + lineSeparator()
        );
        //endregion
    }
}