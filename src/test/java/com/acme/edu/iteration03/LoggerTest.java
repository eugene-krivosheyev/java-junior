package com.acme.edu.iteration03;

import com.acme.edu.LogOperationException;
import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() {
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
    public void shouldLogIntegersArray() throws LogOperationException {
        //region when
        Logger.log(new int[] {-1, 0, 1});
        Logger.close();
        //endregion

        //region then
        assertSysoutContains(
            "primitives array: {-1, 0, 1}\n"
        );
        //endregion
    }



    @Test
    public void shouldLogIntegersMatrix() throws IOException, LogOperationException {
        //region when
        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Logger.close();
        //endregion

        //region then
        assertSysoutContains(
            "primitives matrix: {\n" +
                "{-1, 0, 1}\n" +
                "{1, 2, 3}\n" +
                "{-1, -2, -3}\n" +
            "}\n"
        );
        //endregion
    }


    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws LogOperationException {
        //region when
        Logger.log(new int[][][][] {{{{0}}}});
        Logger.close();
        //endregion

        //region then
        assertSysoutContains(
            "primitives multimatrix: {\n" +
                "{\n" + "{\n" + "{\n" +
                    "0\n" +
                "}\n" + "}\n" + "}\n" +
            "}\n"
        );
        //endregion
    }


    @Test
    public void shouldLogStringsWithOneMethodCall() throws LogOperationException {
        //region when
        Logger.log("str1", "string 2", "str 3");
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("str1\n");
        assertSysoutContains("string 2\n");
        assertSysoutContains("str 3");
        //endregion
    }


    @Test
    public void shouldLogIntegersWithOneMethodCall() throws LogOperationException {
        //region when
        Logger.log(-1, 0, 1, 3);
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws LogOperationException {
        //region when
        Logger.log(1);
        Logger.log("str");
        Logger.log(Integer.MAX_VALUE - 10);
        Logger.log(9);
        Logger.close();
        //endregion

        //region then
        assertSysoutContains(String.valueOf(1));
        assertSysoutContains("str");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE - 10));
        assertSysoutContains(String.valueOf(9));
        //endregion
    }

}