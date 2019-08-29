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
        assertSysoutContains("str 1\n");
        assertSysoutContains("3\n");
        assertSysoutContains("str 2\n");
        assertSysoutContains("0\n");
        //endregion
    }



    @Test
    public void shouldLogCorrectlyIntegerUpperOverflowWhenSequentIntegers() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log(15);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1\n");
        assertSysoutContains("11\n");
        assertSysoutContains(Integer.MAX_VALUE + "\n");
        assertSysoutContains("15\n");
        assertSysoutContains("str 2\n");
        assertSysoutContains("0\n");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerLowerOverflowWhenSequentIntegers() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(-1);
        Logger.log(-10);
        Logger.log(Integer.MIN_VALUE);
        Logger.log(-15);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1\n");
        assertSysoutContains("-11\n");
        assertSysoutContains(Integer.MIN_VALUE + "\n");
        assertSysoutContains("-15\n");
        assertSysoutContains("str 2\n");
        assertSysoutContains("0\n");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1\n");
        assertSysoutContains("10\n");
        assertSysoutContains(Byte.MAX_VALUE + "\n");
        assertSysoutContains("str 2\n");
        assertSysoutContains("0\n");
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
        assertSysoutContains("str 1\n");
        assertSysoutContains("str 2 (x2)\n");
        assertSysoutContains("0\n");
        assertSysoutContains("str 2\n");
        assertSysoutContains("str 3 (x3)\n");
        //endregion
    }

}