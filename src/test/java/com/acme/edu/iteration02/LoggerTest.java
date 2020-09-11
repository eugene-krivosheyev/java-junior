package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.acme.edu.Logger.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private static final String LINE_SEP = System.lineSeparator();
    Logger myTestLogger = new Logger();

    //region given
    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test @Ignore
    public void shouldLogSequentIntegersAsSum() throws LogException, FlushException {
        //region when
        myTestLogger.log("str 1");
        myTestLogger.log(1);
        myTestLogger.log(2);
        myTestLogger.log("str 2");
        myTestLogger.log(0);
        myTestLogger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + LINE_SEP +
            "primitive: 3" + LINE_SEP +
            "string: str 2" + LINE_SEP +
            "primitive: 0" + LINE_SEP
        );
        //endregion
    }

    @Test @Ignore
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws LogException, FlushException {
        //region when
        myTestLogger.log("str 1");
        myTestLogger.log(10);
        myTestLogger.log(Integer.MAX_VALUE);
        myTestLogger.log("str 2");
        myTestLogger.log(0);
        myTestLogger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + LINE_SEP +
            "primitive: 10" + LINE_SEP + "primitive: " +
            Integer.MAX_VALUE + LINE_SEP +
            "string: str 2" + LINE_SEP +
            "primitive: 0" + LINE_SEP
        );
        //endregion
    }

    /*
    @Test
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
            "string: str 1" + LINE_SEP +
            "primitive: 10" + LINE_SEP + "primitive: " +
            Byte.MAX_VALUE + LINE_SEP +
            "string: str 2" + LINE_SEP +
            "primitive: 0" + LINE_SEP
        );
        //endregion
    }
    */

    @Test @Ignore
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws LogException, FlushException {
        //region when
        myTestLogger.log("str 1");
        myTestLogger.log("str 2");
        myTestLogger.log("str 2");
        myTestLogger.log(0);
        myTestLogger.log("str 2");
        myTestLogger.log("str 3");
        myTestLogger.log("str 3");
        myTestLogger.log("str 3");
        myTestLogger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + LINE_SEP +
            "string: str 2 (x2)" + LINE_SEP +
            "primitive: 0" + LINE_SEP +
            "string: str 2" + LINE_SEP +
            "string: str 3 (x3)" + LINE_SEP
        );
        //endregion
    }

    @Test(expected = LogException.class)
    public void shouldThrowExceptionWhenComeEmptyString() throws FlushException, LogException{
        myTestLogger.log(Integer.MAX_VALUE);
        myTestLogger.log(1);
        myTestLogger.flush();
    }
}