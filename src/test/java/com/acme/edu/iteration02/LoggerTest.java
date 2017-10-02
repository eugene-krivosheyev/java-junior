package com.acme.edu.iteration02;

import com.acme.edu.logger.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.logger2.Logger2;
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

    // TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
//        Logger.start();
//        Logger.log("str 1");
//        Logger.log(1);
//        Logger.log(2);
//        Logger.log("str 2");
//        Logger.log(0);
//        Logger.stop();


        Logger2.log("str 1");
        Logger2.log(1);
        Logger2.log(2);
        Logger2.log("str 2");
        Logger2.log(0);
        Logger2.stop();

        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("string: ");

        assertSysoutEquals(
                "string: "   + "str 1\n" +
                        "primitive: " + "3\n"     +
                        "string: "    + "str 2\n" +
                        "primitive: " + "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
//        Logger.start();
//        Logger.log("str 1");
//        Logger.log(10);
//        Logger.log(Integer.MAX_VALUE);
//        Logger.log("str 2");
//        Logger.log(0);
//        Logger.stop();

        Logger2.log("str 1");
        Logger2.log(10);
        Logger2.log(Integer.MAX_VALUE);
        Logger2.log("str 2");
        Logger2.log(0);
        Logger2.stop();

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

}
