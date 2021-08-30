package com.db.edu.iteration03;

import com.db.edu.Logger;
import com.db.edu.LoggerController;
import com.db.edu.Save.SaveException;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Logger3Text implements SysoutCaptureAndAssertionAbility {
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
    public void shouldLogIntegersArray() throws IOException, SaveException {
        //region when
        Logger.log(new int[] {-1, 0, 1});
        //endregion
        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}\n"
        );
        //endregion
    }
    @Test
    @Disabled
    public void shouldLogIntegersMatrix() throws IOException, SaveException {
        //region when
        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion
        //region then
        assertSysoutEquals(
            "primitives matrix: {\n" +
                "{-1, 0, 1}\n" +
                "{1, 2, 3}\n" +
                "{-1, -2, -3}\n" +
            "}\n"
        );
        //endregion
    }
    @Test
    @Disabled
    public void shouldLogIntegersMulitidimentionalArray() throws IOException, SaveException {
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
    @Test
    @Disabled
    public void shouldLogStringsWithOneMethodCall() throws IOException, SaveException {
        //region when
        Logger.log("str1", "string 2", "str 3");
        Logger.loggerController.close();
        //endregion
        //region then
        assertSysoutContains("str1");
        assertSysoutContains("string 2");
        assertSysoutContains("str 3");
        //endregion
    }
    @Test
    @Disabled
    public void shouldLogIntegersWithOneMethodCall() throws IOException, SaveException {
        //region when
        Logger.log(-1, 0, 1, 3);
        Logger.loggerController.close();
        //endregion
        //region then
        assertSysoutContains("3");
        //endregion
    }
    /*
    @Test
    @Disabled
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