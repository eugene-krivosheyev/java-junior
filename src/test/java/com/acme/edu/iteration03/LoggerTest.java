package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @BeforeEach
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Logger.log(true, new int[]{-1, 0, 20});
        //endregion

        //region then
        assertSysoutContains("primitives array: {-1, 0, 20}");
        //endregion
    }

    @Test
    public void shouldLogIntegersArraySum() throws IOException {
        //region when
        Logger.log(new int[]{-1, 0, 20});
        //endregion

        //region then
        assertSysoutContains("19");
        //endregion
    }


    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Logger.log(true, new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -20}});
        //endregion

        //region then
        String linesep = System.lineSeparator();
        assertSysoutEquals("primitives matrix: {" + linesep +
                "{-1, 0, 1}" + linesep +
                "{1, 2, 3}" + linesep +
                "{-1, -2, -20}" + linesep +
                "}" + linesep);
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrixSum() throws IOException {
        //region when
        Logger.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -20}});
        //endregion

        //region then
        assertSysoutContains("-17");
        //endregion
    }

    @Disabled
    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Logger.log(new int[][][][]{{{{0}}}});
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
        Logger.log("str1", "string 2", "str 3");
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str1");
        assertSysoutContains("string 2");
        assertSysoutContains("str 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCallSum() throws IOException {
        //region when
        Logger.log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion

    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Logger.log(true, -1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("primitives array: {-1, 0, 1, 3}");
    }

    @Disabled
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
        assertSysoutContains(Integer.MAX_VALUE - 10 + "");
        assertSysoutContains(11 + "");
        //endregion
    }


}