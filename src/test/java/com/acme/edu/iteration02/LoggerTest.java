package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.LogOperationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
//    @Before
//    public void setUpSystemOut() {
//        resetOut();
//        captureSysout();
//    }
//
//    @After
//    public void tearDown() {
//        resetOut();
//    }
//    //endregion
//
//    @Test
//    public void extraBoundariesTest() throws LogOperationException {
//        //region when
//        Logger.log(1);
//        Logger.log(2);
//        Logger.log(Integer.MAX_VALUE);
//        Logger.log(3);
//        Logger.log(0);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains(Integer.MAX_VALUE + "");
//        assertSysoutContains("6");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogSequentIntegersAsSum() throws LogOperationException {
//        //region when
//        Logger.log("str 1");
//        Logger.log(1);
//        Logger.log(2);
//        Logger.log("str 2");
//        Logger.log(0);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("str 1");
//        assertSysoutContains("3");
//        assertSysoutContains("str 2");
//        assertSysoutContains("0");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws LogOperationException {
//        //region when
//        Logger.log("str 1");
//        Logger.log(10);
//        Logger.log(Integer.MAX_VALUE);
//        Logger.log("str 2");
//        Logger.log(0);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("str 1");
//        assertSysoutContains(Integer.MAX_VALUE + "");
//        assertSysoutContains("10");
//        assertSysoutContains("str 2");
//        assertSysoutContains("0");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws LogOperationException {
//        //region when
//        Logger.log("str 1");
//        Logger.log((byte) 10);
//        Logger.log((byte) Byte.MAX_VALUE);
//        Logger.log("str 2");
//        Logger.log(0);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("str 1");
//        assertSysoutContains("10");
//        assertSysoutContains(Byte.MAX_VALUE + "");
//        assertSysoutContains("str 2");
//        assertSysoutContains("0");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogSameSubsequentStringsWithoutRepeat() throws LogOperationException {
//        //region when
//        Logger.log("str 1");
//        Logger.log("str 2");
//        Logger.log("str 2");
//        Logger.log(0);
//        Logger.log("str 2");
//        Logger.log("str 3");
//        Logger.log("str 3");
//        Logger.log("str 3");
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("str 1");
//        assertSysoutContains("str 2 (x2)");
//        assertSysoutContains("0");
//        assertSysoutContains("str 2");
//        assertSysoutContains("str 3 (x3)");
//        //endregion
//    }
}