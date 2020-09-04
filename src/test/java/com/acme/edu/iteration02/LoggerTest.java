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
        Logger.log("str 2");
        Logger.log(0);
        Logger.end();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator()+
            "3" + System.lineSeparator() +
            "str 2" + System.lineSeparator() +
            "0" +System.lineSeparator()
        );
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
        Logger.end();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator() +
            "10" + System.lineSeparator() +
            Integer.MAX_VALUE + System.lineSeparator() +
            "str 2" + System.lineSeparator() +
            "0" + System.lineSeparator()
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
        Logger.end();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator() +
            "10" + System.lineSeparator() +
            Byte.MAX_VALUE + System.lineSeparator() +
            "str 2" + System.lineSeparator() +
            "0" + System.lineSeparator()
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
        Logger.end();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1" + System.lineSeparator() +
            "str 2 (x2)" +System.lineSeparator()+
            "0" +System.lineSeparator() +
            "str 2" +System.lineSeparator() +
            "str 3 (x3)" +System.lineSeparator()
        );
        //endregion
    }


}