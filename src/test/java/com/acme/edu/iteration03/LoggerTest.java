package com.acme.edu.iteration03;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.ooad.Logger;
import com.acme.edu.ooad.exception.FlushException;
import com.acme.edu.ooad.exception.LogException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private static final String STRING_PREFIX = "string: ";

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
    TODO: implement Logger solution to match specification as tests
    */

    @Test
    public void shouldLogStringsWithOneMethodCall() throws LogException, FlushException {
        //region when
        Logger.log("str1", "string 2", "str 3");
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(STRING_PREFIX + "str1" + System.lineSeparator() +
                STRING_PREFIX + "string 2" + System.lineSeparator() +
                STRING_PREFIX + "str 3" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws LogException, FlushException {
        //region when
        Logger.log(-1, 0, 1, 3);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }
}
