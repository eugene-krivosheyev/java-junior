package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import sun.rmi.runtime.Log;

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


    /*
    TODO: implement Logger solution to match specification as tests
    */
    // FIXME test fails
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
        String delimiter = System.lineSeparator();
        assertSysoutEquals(
            "string: str 1" + delimiter +
            "primitive: 3" + delimiter +
            "string: str 2" + delimiter +
            "primitive: 0" + delimiter
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
        String delimiter = System.lineSeparator();
        assertSysoutEquals(
            "string: str 1" + delimiter +
            "primitive: 10" + delimiter +
            "primitive: " + Integer.MAX_VALUE + delimiter +
            "string: str 2" + delimiter +
            "primitive: 0" + delimiter
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
        String delimiter = System.lineSeparator();
        assertSysoutEquals(
            "string: str 1" + delimiter +
            "primitive: 10" + delimiter +
            "primitive: " + Byte.MAX_VALUE + delimiter +
            "string: str 2" + delimiter +
            "primitive: 0" + delimiter
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
        String delimiter = System.lineSeparator();
        assertSysoutEquals(
            "string: str 1" + delimiter +
            "string: str 2 (x2)" + delimiter +
            "primitive: 0" + delimiter +
            "string: str 2" + delimiter +
            "string: str 3 (x3)" + delimiter
        );
        //endregion
    }


}