package com.db.edu.iteration02;

import com.db.edu.Logger;
import com.db.edu.LoggerController;
import com.db.edu.Save.SaveException;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Logger2Test implements SysoutCaptureAndAssertionAbility {
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


    //TODO: implement Logger solution to match specification as tests
    @Test
    @Disabled
    public void shouldLogSequentIntegersAsSum() throws IOException, SaveException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.loggerController.close();
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
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws SaveException {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.loggerController.close();
        //endregion
        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws SaveException {
        //region when
        Logger.log("str 1");
        Logger.log((byte) 10);
        Logger.log((byte) Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.loggerController.close();
        //endregion
        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Byte.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException, SaveException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.loggerController.close();
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