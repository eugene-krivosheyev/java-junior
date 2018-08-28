package com.acme.edu.messagelog;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LogByteMessageTest implements SysoutCaptureAndAssertionAbility {
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
    public void shouldAccumulateWhenMessagesAreByte(){
        Logger.log((byte) 20);
        Logger.log((byte) 20);
        Logger.log((byte) 20);
        Logger.flush();
        assertSysoutEquals("primitive: 60" + LINE_SEPARATOR);
    }

    @Test
    public void shouldFlushWhenNegativeOverflowForByte(){
        Logger.log((byte)-20);
        Logger.log(Byte.MIN_VALUE);
        Logger.log((byte) 15);
        Logger.flush();
        assertSysoutContains("-20" + LINE_SEPARATOR +
                "primitive: -113" + LINE_SEPARATOR);
    }
}
