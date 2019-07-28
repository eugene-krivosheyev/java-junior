package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.LoggerRegistry;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.saver.ConsoleSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    final public static String LS = System.lineSeparator();
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
        new LoggerRegistry(new ConsoleSaver());
        Logger.reset();
        Logger.setAccumulation(true);
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion



 //   TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        //endregion
        Logger.flush();

        //region then
        assertSysoutEquals(
            "str 1" + LS +
            "3" + LS +
            "str 2" + LS +
            "0" + LS
        );
        //endregion
    }
/*
    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
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
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
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
*/
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
            "str 1" + LS +
            "str 2 (x2)" + LS +
            "0" + LS +
            "str 2" + LS +
            "str 3 (x3)" + LS
        );
        //endregion
    }


}