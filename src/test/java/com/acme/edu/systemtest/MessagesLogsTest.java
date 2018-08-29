package com.acme.edu.systemtest;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
@Ignore
public class MessagesLogsTest implements SysoutCaptureAndAssertionAbility {
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
    public void shouldFlushWhenTypeChanged(){
        Object stub = new Object();

        Logger.log(1);
        Logger.log((byte) 2);
        Logger.log(true);
        Logger.log(stub);
        Logger.log('q');
        Logger.flush();

        assertSysoutEquals(
                "primitive: 1" + LINE_SEPARATOR +
                "primitive: 2" + LINE_SEPARATOR +
                "primitive: true" + LINE_SEPARATOR +
                "reference: " + stub.toString() + LINE_SEPARATOR +
                "char: q" + LINE_SEPARATOR);
    }

    @Test
    public void shouldNotAccumulateWhenTheTypeIsMatrix(){
        int[][] message1 = {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}};
        int[][] message2 = {{-10, 4}};
        Logger.log(message1);
        Logger.log(message2);
        Logger.flush();

        assertSysoutEquals(
                "primitives matrix: {" + LINE_SEPARATOR +
                        "{-1, 0, 1}" + LINE_SEPARATOR +
                        "{1, 2, 3}" + LINE_SEPARATOR +
                        "{-1, -2, -3}" + LINE_SEPARATOR +
                        "}" + LINE_SEPARATOR +
                        "primitives matrix: {" + LINE_SEPARATOR +
                        "{-10, 4}" + LINE_SEPARATOR +
                        "}" + LINE_SEPARATOR
        );
    }

    @Test
    public void shouldNotAccumulateWhenTheTypeIsArray(){
        int[] message1 = {-1, 0, 1};
        int[] message2 = {-10, 4};
        Logger.log(message1);
        Logger.log(message2);
        Logger.flush();

        assertSysoutEquals(
                "primitives array: {-1, 0, 1}" + LINE_SEPARATOR +
                        "primitives array: {-10, 4}" + LINE_SEPARATOR
        );
    }

}
