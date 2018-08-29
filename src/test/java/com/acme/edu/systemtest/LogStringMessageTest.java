package com.acme.edu.systemtest;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

@Ignore
public class LogStringMessageTest implements SysoutCaptureAndAssertionAbility {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldAccumulateWhenSeveralMessages(){
        Logger.log("str 1");
        Logger.log("str 1");
        Logger.log("str 1");
        Logger.flush();
        assertSysoutEquals("string: str 1 (x3)" + LINE_SEPARATOR);
    }

    @Test
    public void shouldFlushWhenTheStringIsChanged(){
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.flush();
        assertSysoutEquals(
                "string: str 1" + LINE_SEPARATOR +
                "string: str 2" + LINE_SEPARATOR);
    }
}
