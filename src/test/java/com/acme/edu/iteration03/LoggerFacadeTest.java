package com.acme.edu.iteration03;

import com.acme.edu.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exception.LoggerControllerException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class LoggerFacadeTest implements SysoutCaptureAndAssertionAbility {
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
    @Ignore
    public void shouldLogIntegersArray() throws LoggerControllerException {
        //region when
        LoggerFacade.log(new int[] {-1, 0, 1});
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: [-1, 0, 1]" + lineSeparator()
        );
        //endregion
    }

    @Test
    @Ignore
    public void shouldLogIntegersMatrix() throws LoggerControllerException {
        //region when
        LoggerFacade.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: [" +
                "[-1, 0, 1]" + lineSeparator() +
                "[1, 2, 3]" + lineSeparator() +
                "[-1, -2, -3]" + "]" + lineSeparator()
        );
        //endregion
    }

    @Test
    @Ignore
    public void shouldLogIntegersMulitidimentionalArray() throws LoggerControllerException {
        //region when
        LoggerFacade.log(new int[][][][] {{{{0}}}});
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: [" + lineSeparator() +
                "[" + lineSeparator() + "[" + lineSeparator() + "[" + lineSeparator() +
                    "0" + lineSeparator() +
                "]" + lineSeparator() + "]" + lineSeparator() + "]" + lineSeparator() +
            "]" + lineSeparator()
        );
        //endregion
    }

    /*
    TODO: implement Logger solution to match specification as tests

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