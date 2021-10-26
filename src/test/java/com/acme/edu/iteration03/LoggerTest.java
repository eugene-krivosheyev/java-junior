package com.acme.edu.iteration03;

import com.acme.edu.LoggerDeprecated;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    public static final String sep = lineSeparator();
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
    @Disabled
    public void shouldLogIntegersArray() throws IOException {
        //region when
        LoggerDeprecated.log(new int[] {-1, 0, 1});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        LoggerDeprecated.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        LoggerDeprecated.flush();
        //endregion

        //region then
        assertSysoutContains(
            "primitives matrix: 0"+sep
        );
        //endregion
    }

    @Test @Disabled
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        LoggerDeprecated.log(new int[][][][] {{{{0}}}});
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
//        Logger.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1\nstring 2\nstr 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        LoggerDeprecated.log(-1, 0, 1, 3);
        LoggerDeprecated.flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test @Disabled
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        LoggerDeprecated.log(1);
        LoggerDeprecated.log("str");
        LoggerDeprecated.log(Integer.MAX_VALUE - 10);
        LoggerDeprecated.log(11);
        //endregion

        //region then
//        assertSysoutContains(1);
//        assertSysoutContains("str");
//        assertSysoutContains(Integer.MAX_VALUE - 10);
//        assertSysoutContains(11);
        //endregion
    }
}