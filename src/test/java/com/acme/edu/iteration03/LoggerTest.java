package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.LogOperationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
//    public void shouldLogIntegersArray() throws LogOperationException {
//        //region when
//        Logger.log((int[])new int[]{-1, 0, 1});
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//                "primitives array: {-1, 0, 1}" + System.lineSeparator()
//        );
//        //endregion
//    }
//
////    @Test
////    public void shouldLogIntegersMatrix() throws LogOperationException {
////        //region when
////        Logger.log(new int[][]{{0}});
////        Logger.close();
////        //endregion
////
////        //region then
////        assertSysoutEquals(
////                "primitives matrix: {" + System.lineSeparator() +
////                        "{-1, 0, 1}" + System.lineSeparator() +
////                        "{1, 2, 3}" + System.lineSeparator() +
////                        "{-1, -2, -3}" + System.lineSeparator() +
////                        "}" + System.lineSeparator()
////        );
////        //endregion
////    }
//
////    @Test
////    public void shouldLogIntegersMulitidimentionalArray() throws IOException, LogOperationException {
////        //region when
////        Logger.log((int[][][][])new int[][][][]{{{{0}}}});
////        Logger.close();
////        //endregion
////
////        //region then
////        assertSysoutEquals(
////                "primitives multimatrix: {" + System.lineSeparator() +
////                        "{" + System.lineSeparator() + "{" + System.lineSeparator() + "{" + System.lineSeparator() +
////                        "0" + System.lineSeparator() +
////                        "}" + System.lineSeparator() + "}" + System.lineSeparator() + "}" + System.lineSeparator() +
////                        "}" + System.lineSeparator()
////        );
////        //endregion
////    }
//
//    @Test
//    public void shouldLogStringsWithOneMethodCall() throws LogOperationException {
//        //region when
//        Logger.log("str1", "string 2", "str 3");
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("str1\nstring 2\nstr 3");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogIntegersWithOneMethodCall() throws IOException, LogOperationException {
//        //region when
//        Logger.log(-1, 0, 1, 3);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("3");
//        //endregion
//    }
//
//    @Test
//    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException, LogOperationException {
//        //region when
//        Logger.log(1);
//        Logger.log("str");
//        Logger.log(Integer.MAX_VALUE - 10);
//        Logger.log(11);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("1");
//        assertSysoutContains("str");
//        assertSysoutContains(Integer.MAX_VALUE + "");
//        assertSysoutContains("1");
//        //endregion
//    }
}