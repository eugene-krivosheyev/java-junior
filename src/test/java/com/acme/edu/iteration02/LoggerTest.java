package com.acme.edu.iteration02;

import com.acme.edu.Logger;
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

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.cachePrint();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + lineSeparator() +
            "primitive: 3" + lineSeparator() +
            "string: str 2" + lineSeparator() +
            "primitive: 0" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.cachePrint();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + lineSeparator() +
            "primitive: " + Integer.MAX_VALUE + lineSeparator() +
            "primitive: 12" + lineSeparator() +
            "string: str 2" + lineSeparator() +
            "primitive: 0" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log((byte)2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.cachePrint();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + lineSeparator() +
            "primitive: " + Byte.MAX_VALUE + lineSeparator() +
            "primitive: 12" + lineSeparator() +
            "string: str 2" + lineSeparator() +
            "primitive: 0" + lineSeparator()
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
        Logger.cachePrint();
        //endregion

        //region then
        assertSysoutContains(
            "string: str 1" + lineSeparator() +
            "string: str 2 (x2)" + lineSeparator() +
            "primitive: 0" + lineSeparator() +
            "string: str 2" + lineSeparator() +
            "string: str 3 (x3)" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldIgnoreEmptyStringsAndNullObjects() throws IOException {
        //region when
        final Object nullObject = null;
        Logger.log("str 1");
        Logger.log("str 1");
        Logger.log("");
        Logger.log("");
        Logger.log("");
        Logger.log("str 1");
        Logger.log(nullObject);
        Logger.log("str 2");
        Logger.log(6);
        Logger.log("");
        Logger.log(nullObject);
        Logger.log(8);
        Logger.cachePrint();
        //endregion

        //region then
        assertSysoutContains(
                "string: str 1 (x3)" + lineSeparator() +
                "string: str 2" + lineSeparator() +
                "primitive: 14" + lineSeparator()

            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)\n"

        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyNegativeIntegerOverflowWhenSequentIntegers() throws IOException {
        //region when
        Logger.log(-5);
        Logger.log(Integer.MIN_VALUE);
        Logger.log(-8);
        Logger.cachePrint();
        //endregion

        //region then
        assertSysoutContains(
            "primitive: " + Integer.MIN_VALUE + lineSeparator() +
            "primitive: -13" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyNegativeByteOverflowWhenSequentIntegers() throws IOException {
        //region when
        Logger.log((byte)-5);
        Logger.log(Byte.MIN_VALUE);
        Logger.log((byte)-8);
        Logger.cachePrint();
        //endregion

        //region then
        assertSysoutContains(
            "primitive: " + Byte.MIN_VALUE + lineSeparator() +
            "primitive: -13" + lineSeparator()
        );
        //endregion
    }
}