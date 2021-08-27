package com.db.edu.iteration02;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @BeforeEach
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion


    @Test
    @Disabled
    public void shouldLogSequentIntegersAsSum() throws AssertionError {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("3");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws AssertionError {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(Integer.toString(Integer.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws AssertionError {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(Byte.toString(Byte.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws AssertionError {
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
        assertSysoutContains("str 1");
        assertSysoutContains("str 2 (x2)");
        assertSysoutContains("0");
        assertSysoutContains("str 2");
        assertSysoutContains("str 3 (x3)");
        //endregion
    }
}