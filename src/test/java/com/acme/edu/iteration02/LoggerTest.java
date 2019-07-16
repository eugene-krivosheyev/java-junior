package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private String separator = System.lineSeparator();

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
    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);

        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + separator +
                        "3" + separator +
                        "str 2" + separator +
                        "0" + separator
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

        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + separator +
                        "10" + separator +
                        Integer.MAX_VALUE + separator +
                        "str 2" + separator +
                        "0" + separator
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte) 10);
        Logger.log((byte) Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);

        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + separator +
                        "10" + separator +
                        Byte.MAX_VALUE + separator +
                        "str 2" + separator +
                        "0" + separator
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

        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + separator +
                        "str 2 (x2)" + separator +
                        "0" + separator +
                        "str 2" + separator +
                        "str 3 (x3)" + separator
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectMinusIntOverflow() throws IOException {
        Logger.log(-10);
        Logger.log(Integer.MAX_VALUE);
        Logger.close();

        assertSysoutContains(String.valueOf(Integer.MAX_VALUE-10));
    }

    @Test
    public void shouldLogCorrectMinusIntOverflowWithMinValue() throws IOException {
        Logger.log(-10);
        Logger.log(Integer.MIN_VALUE);
        Logger.close();

        assertSysoutContains("-10");
        assertSysoutContains(String.valueOf(Integer.MIN_VALUE));
    }

    @Test
    public void shouldLogCorrectMinusByteOverflow() throws IOException {
        Logger.log((byte) -10);
        Logger.log(Byte.MAX_VALUE);
        Logger.close();

        assertSysoutContains(String.valueOf(Byte.MAX_VALUE-10));
    }

    @Test
    public void shouldLogCorrectMinusByteOverflowWithMinValue() throws IOException {
        Logger.log((byte) -10);
        Logger.log(Byte.MIN_VALUE);
        Logger.close();

        assertSysoutContains("-10");
        assertSysoutContains(String.valueOf(Byte.MIN_VALUE));
    }
}