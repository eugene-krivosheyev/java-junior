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



    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.flushStart();
        Logger.log(1);
        Logger.log(2);
        Logger.flushStart();
        Logger.log("str 2");
        Logger.flushStart();
        Logger.log(0);
        Logger.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + System.lineSeparator() +
            "primitive: 3" + System.lineSeparator() +
            "string: str 2" + System.lineSeparator() +
            "primitive: 0" + System.lineSeparator()
        );
        //endregion
    }




    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.flushStart();
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE-1);
        Logger.log(Integer.MAX_VALUE-2);
        Logger.flushStart();
        Logger.log("str 2");
        Logger.flushStart();
        Logger.log(0);
        Logger.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + System.lineSeparator() +
            "primitive: " + Integer.MAX_VALUE + System.lineSeparator() +
            "primitive: " + Integer.MAX_VALUE + System.lineSeparator() +
            "primitive: 7" + System.lineSeparator() +
            "string: str 2" + System.lineSeparator() +
            "primitive: 0" + System.lineSeparator()
        );
        //endregion
    }



    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.flushStart();
        Logger.log((byte)10);
        Logger.log(Byte.MAX_VALUE);
        Logger.flushStart();
        Logger.log("str 2");
        Logger.flushStart();
        Logger.log(0);
        Logger.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + System.lineSeparator() +
            "primitive: " + Byte.MAX_VALUE + System.lineSeparator() +
            "primitive: 10" + System.lineSeparator() +
            "string: str 2" + System.lineSeparator() +
            "primitive: 0" + System.lineSeparator()
        );
        //endregion
    }

/*
    TODO: implement Logger solution to match specification as tests

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