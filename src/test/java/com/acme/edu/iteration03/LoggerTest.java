package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    private static final String LINE_SEPARATOR = System.lineSeparator();
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


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        int[] array = new int[] {-1, 0, 1};
        Logger.log(array);
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        int[][] message = {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}};
        Logger.log(message);
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {" + LINE_SEPARATOR +
                "{-1, 0, 1}" + LINE_SEPARATOR +
                "{1, 2, 3}" + LINE_SEPARATOR +
                "{-1, -2, -3}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR
        );
        //endregion
    }
/*
    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Logger.log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {" + LINE_SEPARATOR +
                "{" + LINE_SEPARATOR + "{" + LINE_SEPARATOR + "{" + LINE_SEPARATOR +
                    "0" + LINE_SEPARATOR +
                "}" + LINE_SEPARATOR + "}" + LINE_SEPARATOR + "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Logger.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1\nstring 2\nstr 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Logger.log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        Logger.log(1);
        Logger.log("str");
        Logger.log(Integer.MAX_VALUE - 10);
        Logger.log(11);
        //endregion

        //region then
        assertSysoutContains(1);
        assertSysoutContains("str");
        assertSysoutContains(Integer.MAX_VALUE - 10);
        assertSysoutContains(11);
        //endregion
    }

    */
}