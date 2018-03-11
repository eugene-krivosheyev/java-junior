package com.acme.edu.iteration03;

import com.acme.edu.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

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


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        LoggerFacade.log(new int[] {-1, 0, 1});
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("primitives array: {");
        assertSysoutContains("-1, 0, 1}"+lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        LoggerFacade.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("primitives matrix: {" + lineSeparator());
        assertSysoutContains("{-1, 0, 1}" + lineSeparator());
        assertSysoutContains("{1, 2, 3}" + lineSeparator());
        assertSysoutContains("{-1, -2, -3}" + lineSeparator());
        assertSysoutContains("}" + lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        LoggerFacade.log(new int[][][][] {{{{0}}}});
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("primitives multimatrix: {" + lineSeparator());
        assertSysoutContains("{"+lineSeparator());
        assertSysoutContains("{"+lineSeparator());
        assertSysoutContains("{" +lineSeparator());
        assertSysoutContains("0" +lineSeparator());
        assertSysoutContains("}"+lineSeparator());
        assertSysoutContains("}" +lineSeparator());
        assertSysoutContains("}" +lineSeparator());
        assertSysoutContains("}"+lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        LoggerFacade.log("str1", "string 2", "str 3");
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("str1"+lineSeparator());
        assertSysoutContains("string 2"+lineSeparator());
        assertSysoutContains("str 3"+lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        LoggerFacade.log(-1, 0, 1, 3);
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        LoggerFacade.log(1);
        LoggerFacade.log("str");
        LoggerFacade.log(Integer.MAX_VALUE - 10);
        LoggerFacade.log(11);
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains(1+lineSeparator());
        assertSysoutContains("str"+lineSeparator());
        assertSysoutContains(Integer.MAX_VALUE+lineSeparator());
        assertSysoutContains(1+lineSeparator());
        //endregion
    }
}