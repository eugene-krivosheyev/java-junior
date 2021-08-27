package com.db.education.app.Iteration3;

import com.db.education.app.Logger;
import com.db.education.app.SysoutCaptureAndAssertionAbility;
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

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Logger.log("str1", "string 2", "str 3");
        Logger.flush();
        //endregion
        //region then
        String s = System.lineSeparator();
        assertSysoutContains("str1" + s);
        assertSysoutContains( "string 2" + s);
        assertSysoutContains("str 3" + s);
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Logger.log(-1, 0, 1, 3);
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("3");
        //endregion
    }
}