package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @BeforeEach
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    @Disabled
    public void shouldLogIntegersArray() {
        //region when
        Logger.log(new int[]{-1, 0, 1});
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives array: {-1, 0, 1}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() {
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
    public void shouldLogIntegersWithOneMethodCall() {
        //region when
        Logger.log(-1, 0, 1, 3);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    @Disabled
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() {
        //region when
        Logger.log(1);
        Logger.log("str");
        Logger.log(Integer.MAX_VALUE - 10);
        Logger.log(11);
        Logger.flush();

        //endregion

        //region then
        assertSysoutContains(1);
        assertSysoutContains("str");
        assertSysoutContains(Integer.MAX_VALUE);
        assertSysoutContains(1);
        //endregion
    }
}