//package com.acme.edu.iteration02;
//
//import com.acme.edu.Logger;
//import SysoutCaptureAndAssertionAbility;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//
//public class LoggerTest implements SysoutCaptureAndAssertionAbility {
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
//    public void shouldLogSequentIntegersAsSum() throws IOException {
//        //region when
//        Logger.log("str 1");
//        Logger.log(1);
//        Logger.log(2);
//        Logger.log("str 2");
//        Logger.log(0);
//        Logger.flush();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//                "string: str 1\n" +
//                        "primitive: 3\n" +
//                        "string: str 2\n" +
//                        "primitive: 0\n"
//        );
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
//        Logger.flush();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//                "str 1\n" +
//                        "10\n" +
//                        Integer.MAX_VALUE + "\n" +
//                        "str 2\n" +
//                        "0\n"
//        );
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
//        Logger.flush();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//                "string: str 1\n" +
//                        "primitive: 10\n" +
//                        "primitive: " + Byte.MAX_VALUE + "\n" +
//                        "string: str 2\n" +
//                        "primitive: 0\n"
//        );
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
//        Logger.flush();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//                "str 1\n" +
//                        "str 2 (x2)\n" +
//                        "0\n" +
//                        "str 2\n" +
//                        "str 3 (x3)\n"
//        );
//        //endregion
//    }
//}