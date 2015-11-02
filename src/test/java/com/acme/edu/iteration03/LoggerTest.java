package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private static final String SEP = System.lineSeparator();
    private Logger logger;
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        logger = new Logger();
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
        logger.log(new int[] {-1, 0, 1});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {" + SEP +
                "{-1, 0, 1}" + SEP +
                "{1, 2, 3}" + SEP +
                "{-1, -2, -3}" + SEP +
            "}" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        logger.log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {" + SEP +
                "{"+ SEP + "{"+ SEP + "{"+ SEP +
                    "0" + SEP +
                "}"+ SEP + "}"+ SEP + "}"+ SEP +
            "}"+ SEP
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        logger.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1" + SEP + "string 2" + SEP + "str 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        logger.log(new int[] {-1, 0, 1, 3});
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        logger.log(1);
        logger.log("str");
        logger.log(Integer.MAX_VALUE - 10);
        logger.log(11);
        logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: " + String.valueOf(1));
        assertSysoutContains("string: str");
        assertSysoutContains("primitive: " + String.valueOf(Integer.MAX_VALUE - 10));
        assertSysoutContains("primitive: " + String.valueOf(11));
        //endregion
    }

}