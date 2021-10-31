package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Disabled
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
    /*
    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Logger.log(new int[] {-1, 0, 1});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}\n"
        );
        //endregion
    }
    */
    @Test
    @Disabled
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Logger.log(1);
        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -2}});
        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("1");
        assertSysoutContains("1");
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
    @Disabled
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Logger.log("str1");
        Logger.log("abc", "str1");
        Logger.log("str1", "string 2", "str 3");
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str1");
        assertSysoutContains("abc");
        assertSysoutContains("str1 (x2)");
        assertSysoutContains("string 2");
        assertSysoutContains("str 3");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Logger.log(1);
        Logger.log(-1, 0, 1, 3);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("1");
        assertSysoutContains("3");
        //endregion
    }
    /*
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