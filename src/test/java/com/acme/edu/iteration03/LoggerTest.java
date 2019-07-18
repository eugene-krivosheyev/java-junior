package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    private String separator = System.lineSeparator();

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
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Logger.log(new int[]{-1, 0, 1});
        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives array: {-1, 0, 1}" + separator
        );
        //endregion
    }
/*
    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Logger.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives matrix: {" + separator +
                        "{-1, 0, 1}" + separator +
                        "{1, 2, 3}" + separator +
                        "{-1, -2, -3}" + separator +
                        "}" + separator
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Logger.log(new int[][][][]{{{{0}}}});
        Logger.close();
        //endregion
        //region then
        assertSysoutEquals(
                "primitives multimatrix: {" + separator +
                        "{" + separator + "{" + separator + "{" +
                        "0" +
                        "}" + separator + "}" + separator + "}" + separator +
                        "}" + separator
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Logger.log("str1", "string 2", "str 3");
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("str1" + separator + "string 2" + separator + "str 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Logger.log(-1, 0, 1, 3);
        Logger.close();
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
        Logger.close();
        //endregion

        //region then
        assertSysoutContains(String.valueOf(1));
        assertSysoutContains("str");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE - 10));
        assertSysoutContains(String.valueOf(11));
        //endregion
    }
*/

}