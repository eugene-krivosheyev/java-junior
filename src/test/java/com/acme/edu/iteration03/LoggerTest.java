package com.acme.edu.iteration03;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.TypeCodeEnum;
import com.acme.edu.logger.ComplexLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private final ComplexLogger logger = new ComplexLogger();
    private static String type;

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
    public void shouldLogIntegersArraySum() throws IOException {
        type = TypeCodeEnum.ARRAY_INT.getTypeReference();
        //region when
        logger.log(new int[]{-1, 0, 1});
        //endregion

        //region then
        checkLog("0");
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrixSum() throws IOException {
        type = TypeCodeEnum.MATRIX_INT.getTypeReference();
        //region when
        logger.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        checkLog("0");
        //endregion
    }
/*
    @Test @Ignore
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Logger.log(new int[][][][] {{{{0}}}});
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
    */

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        type = TypeCodeEnum.NONE.getTypeReference();
        //region when
        logger.log("str1", "string 2", "str 3");
        //endregion

        //region then
        checkLog("str1", "string 2", "str 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        type = TypeCodeEnum.NONE.getTypeReference();
        //region when
        logger.log(-1, 0, 1, 3);
        //endregion

        //region then
        checkLog("3");
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

    private void checkLog(String... valuesToCheck) throws IOException {
        for (String valueToCheck : valuesToCheck) {
            assertSysoutContains(type + valueToCheck);
        }
    }
}