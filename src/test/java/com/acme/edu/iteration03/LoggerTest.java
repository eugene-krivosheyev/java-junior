package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static com.acme.edu.iteration01.LoggerTest.sep;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private Logger logger;
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        logger= new Logger();
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
        logger = new Logger(true);
        logger.log(new int[] {-1, 0, 1});
        logger.flush();
        //endregion

        //region then
        assertSysoutContains(
            "primitives array: {-1, 0, 1}"
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: 0"
        );
        //endregion
    }

    @Test @Ignore
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        logger.log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {\n" +
                "{\n" + "{\n" + "{\n" +
                    "0\n" +
                "}\n" + "}\n" + "}\n" +
            "}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        logger.log("str1", "string 2", "str 3");
        logger.flush();
        //endregion

        //region then
        assertSysoutContains("str1" + sep + "string 2" + sep + "str 3");
        //endregion
    }


    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        logger = new Logger(false);
        logger.log(-1, 0, 1, 3);
        logger.flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    /*
    @Test @Ignore
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