package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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

    @Test @Ignore
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" +
            System.lineSeparator() +
            "primitive: 3" +
            System.lineSeparator() +
            "string: str 2" +
            System.lineSeparator() +
            "primitive: 0" +
            System.lineSeparator()
        );
        //endregion
    }

    @Test @Ignore
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
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
            "string: str 1" +
            System.lineSeparator() +
            "primitive: 10" +
            System.lineSeparator() +
            "primitive: " + Integer.MAX_VALUE +
            System.lineSeparator() +
            "string: str 2" +
            System.lineSeparator() +
            "primitive: 0" +
            System.lineSeparator()
        );
        //endregion
    }

    @Test @Ignore
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
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
            "string: str 1" +
            System.lineSeparator() +
            "primitive: 10" +
            System.lineSeparator() +
            "primitive: " + Byte.MAX_VALUE +
            System.lineSeparator() +
            "string: str 2" +
            System.lineSeparator() +
            "primitive: 0" +
            System.lineSeparator()
        );
        //endregion
    }

    @Test @Ignore
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
            "string: str 1" +
            System.lineSeparator() +
            "string: str 2 (x2)" +
            System.lineSeparator() +
            "primitive: 0" +
            System.lineSeparator() +
            "string: str 2" +
            System.lineSeparator() +
            "string: str 3 (x3)" +
            System.lineSeparator()
        );
        //endregion
    }

}