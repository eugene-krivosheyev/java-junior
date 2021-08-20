package com.db.edu.iteration02;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @BeforeEach
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @AfterEach
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
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("primitive: 3");
        assertSysoutContains("primitive: 0");
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
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("positive overflow: " + Integer.MAX_VALUE);
        assertSysoutContains("primitive: 10");
        //endregion
    }
    @Test
    public void shouldLogCorrectlyIntegerNegativeOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(-10);
        Logger.log(Integer.MIN_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("negative overflow: " + Integer.MIN_VALUE);
        assertSysoutContains("primitive: -10");
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
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("positive overflow: " + Byte.MAX_VALUE);
        assertSysoutContains("primitive: 10");
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
        Logger.flush();
        //endregion
        //region then
        String ls = System.lineSeparator();
        assertSysoutContains("string: str 2 (x2)");
        assertSysoutContains("string: str 2" + ls);
        assertSysoutContains("string: str 3 (x3)");
        //endregion
    }
}