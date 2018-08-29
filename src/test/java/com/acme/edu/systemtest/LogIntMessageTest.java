package com.acme.edu.systemtest;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
@Ignore
public class LogIntMessageTest implements SysoutCaptureAndAssertionAbility {
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
        Logger.log(20);
        Logger.log(20);
        Logger.log(20);
        Logger.flush();
        assertSysoutEquals("primitive: 60" + LINE_SEPARATOR);
    }

    @Test
    public void shouldFlushWhenNegativeOverflow(){
        Logger.log(-20);
        Logger.log(Integer.MIN_VALUE);
        Logger.log(15);
        Logger.flush();
        assertSysoutEquals("primitive: -20" + LINE_SEPARATOR +
                "primitive: -2147483633" + LINE_SEPARATOR);
    }

    @Test
    public void shouldFlushWhenPositiveOverflowForByte(){
        Logger.log(20);
        Logger.log(Integer.MAX_VALUE);
        Logger.log(-15);
        Logger.flush();
        assertSysoutEquals(
                "primitive: 20" + LINE_SEPARATOR +
                "primitive: 2147483632" + LINE_SEPARATOR);
    }
}
