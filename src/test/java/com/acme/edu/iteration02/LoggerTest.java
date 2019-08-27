package com.acme.edu.iteration02;

import com.acme.edu.SysoutCaptureAndAssertionAbility;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
//    //region given
//    @Before
//    public void setUpSystemOut() throws IOException {
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
//    public void extraBoundariesTest() throws IOException {
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
//        assertSysoutContains(Integer.MAX_VALUE + "\n");
//        assertSysoutContains("6\n");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogSequentIntegersAsSum() throws IOException {
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
//        assertSysoutContains("str 1\n");
//        assertSysoutContains("3\n");
//        assertSysoutContains("str 2\n");
//        assertSysoutContains("0\n");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
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
//        assertSysoutContains("str 1\n");
//        assertSysoutContains(Integer.MAX_VALUE + "\n");
//        assertSysoutContains("10\n");
//        assertSysoutContains("str 2\n");
//        assertSysoutContains("0\n");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
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
//        assertSysoutContains("str 1\n");
//        assertSysoutContains("10\n");
//        assertSysoutContains(Byte.MAX_VALUE + "\n");
//        assertSysoutContains("str 2\n");
//        assertSysoutContains("0\n");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
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
//        assertSysoutContains("str 1\n");
//        assertSysoutContains("str 2 (x2)\n");
//        assertSysoutContains("0\n");
//        assertSysoutContains("str 2\n");
//        assertSysoutContains("str 3 (x3)\n");
//        //endregion
//    }
}