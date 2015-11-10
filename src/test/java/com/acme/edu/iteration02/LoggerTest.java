package com.acme.edu.iteration02;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.Before;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        captureSysout();
    }
    //endregion


    /*
    TODO: implement SuperLogger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        SuperLogger.log("str 1");
        SuperLogger.log(1);
        SuperLogger.log(2);
        SuperLogger.log("str 2");
        SuperLogger.log(0);
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

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        SuperLogger.log("str 1");
        SuperLogger.log(10);
        SuperLogger.log(Integer.MAX_VALUE);
        SuperLogger.log("str 2");
        SuperLogger.log(0);
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
        SuperLogger.log("str 1");
        SuperLogger.log((byte)10);
        SuperLogger.log((byte)Byte.MAX_VALUE);
        SuperLogger.log("str 2");
        SuperLogger.log(0);
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
        SuperLogger.log("str 1");
        SuperLogger.log("str 2");
        SuperLogger.log("str 2");
        SuperLogger.log(0);
        SuperLogger.log("str 2");
        SuperLogger.log("str 3");
        SuperLogger.log("str 3");
        SuperLogger.log("str 3");
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