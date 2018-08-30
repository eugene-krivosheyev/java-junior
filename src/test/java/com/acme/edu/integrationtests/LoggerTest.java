package com.acme.edu.integrationtests;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoggerTest implements SysoutCaptureAndAssertionAbility{
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
    public void shouldReturnZeroWhenLogIsSuccessful() {
        int returnCode = Logger.log(1);
        Logger.flush();
        assertEquals(0, returnCode);
    }

    @Test
    public void shouldLogNullAsReference() {
        int returnCode1 = Logger.log((Object)null);
        int returnCode2 = Logger.flush();

        assertEquals(0, returnCode1);
        assertEquals(0, returnCode2);
        assertSysoutEquals("reference: null" + System.lineSeparator());
    }
}
