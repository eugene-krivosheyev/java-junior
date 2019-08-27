package com.acme.edu.iteration03;

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


    String separator = System.lineSeparator();


    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Logger.log(new int[] {-1, 0, 1});
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: [-1, 0, 1]" + separator
        );
        //endregion
    }


    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: [" + separator +
                "[-1, 0, 1]" + separator +
                    "[1, 2, 3]" + separator +
                "[-1, -2, -3]" + separator +
            "]" + separator
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Logger.log(new int[][][][] {{{{0}}}});
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: [" + separator +
                "[" + separator  + "[" + separator + "[" +
                    "0" +
                "]" + separator + "]" + separator + "]" + separator  +
            "]" + separator
        );
        //endregion
    }

// todo ask
//    @Test
//    public void shouldLogStringsWithOneMethodCall() throws IOException {
//        //region when
//        Logger.log("str1", "string 2", "str 3");
//        Logger.flush();
//        //endregion
//
//        //region then
//        assertSysoutContains("str1\nstring 2\nstr 3");
//        //endregion
//    }

    // todo ask
    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Logger.log(-1, 0, 1, 3);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Ignore
    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        Logger.log(1);
        Logger.log("str");
        Logger.log(Integer.MAX_VALUE - 10);
        Logger.log(11);
        //endregion

        //region then
        assertSysoutContains("1");
        assertSysoutContains("str");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE - 10));
        assertSysoutContains("11");
        //endregion
    }


}