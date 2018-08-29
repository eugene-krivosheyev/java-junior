package com.acme.edu.iteration06;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.decorator.BinaryIntDecorator;
import com.acme.edu.decorator.DefaultIntDecorator;
import com.acme.edu.message.MessageType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    //region Test Decoration
    @Test @Ignore
    public void shouldLogIntegerWithDecoration() throws IOException {
        Logger.log(1);
        Logger.flush();
        Logger.log(5);
        Logger.flush();

        assertSysoutContains("primitive: 1");
        assertSysoutContains("primitive: 5");
    }

    @Test @Ignore
    public void shouldLogByteWithDecoration() throws IOException {
        Logger.log((byte)1);
        Logger.flush();
        Logger.log((byte)5);
        Logger.flush();

        assertSysoutContains("primitive: 1");
        assertSysoutContains("primitive: 5");
    }

    @Test @Ignore
    public void shouldLogCharWithDecoration() throws IOException {
        Logger.log('a');
        Logger.flush();
        Logger.log('b');
        Logger.flush();

        assertSysoutContains("char: a");
        assertSysoutContains("char: b");
    }

    @Test @Ignore
    public void shouldLogStringWithDecoration() throws IOException {
        Logger.log("test string 1");
        Logger.flush();
        Logger.log("other str");
        Logger.flush();

        assertSysoutContains("string: test string 1");
        assertSysoutContains("string: other str");
    }

    @Test @Ignore
    public void shouldLogBooleanWithDecoration() throws IOException {
        Logger.log(true);
        Logger.flush();
        Logger.log(false);
        Logger.flush();

        assertSysoutContains("primitive: true");
        assertSysoutContains("primitive: false");
    }

    @Test @Ignore
    public void shouldLogReferenceWithDecoration() throws IOException {
        Logger.log(new Object());
        Logger.flush();

        assertSysoutContains("reference: ");
        assertSysoutContains("@");
    }

    @Test @Ignore
    public void shouldLogIntegersArrayWithDecoration() throws IOException {
        Logger.log(new int[]{1, 2, 3});
        Logger.flush();

        assertSysoutContains(
                "primitives array: {1, 2, 3}"
        );
    }


    @Test @Ignore
    public void shouldLogIntegersMatrixWithDecoration() throws IOException {
        int[][] message = {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}};
        Logger.log(message);
        Logger.flush();

        assertSysoutEquals(
                "primitives matrix: {" + System.lineSeparator() +
                        "{-1, 0, 1}" + System.lineSeparator() +
                        "{1, 2, 3}" + System.lineSeparator() +
                        "{-1, -2, -3}" + System.lineSeparator() +
                        "}" + System.lineSeparator()
        );
    }
    //endregion

    //region Test Accumulation
    @Test @Ignore
    public void shouldAccumulateInt() throws IOException {
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();

        assertSysoutContains("str 1");
        assertSysoutContains("3");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    @Test @Ignore
    public void shouldAccumulateByte()  throws IOException {
        Logger.log((byte)5);
        Logger.log((byte)15);
        Logger.log(Byte.MAX_VALUE);
        Logger.log((byte)1);
        Logger.flush();

        assertSysoutContains("20");
        assertSysoutContains(String.valueOf(Byte.MAX_VALUE));
        assertSysoutContains("1");
    }

    @Test @Ignore
    public void shouldAccumulateString() throws IOException {
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.flush();

        assertSysoutContains("str 1");
        assertSysoutContains("str 2 (x2)");
        assertSysoutContains("0");
        assertSysoutContains("str 2");
        assertSysoutContains("str 3 (x3)");
    }
    //endregion

    //region Test Different Decorators
    @Test @Ignore
    public void shouldLogWithDifferentDecorators() throws IOException {
        Logger.log(134);
        Logger.flush();
        Logger.setDecorator(MessageType.INT, new BinaryIntDecorator());
        Logger.log(5);
        Logger.flush();
        Logger.setDecorator(MessageType.INT, new DefaultIntDecorator());

        assertSysoutContains("134");
        assertSysoutContains("101");
    }
    //endregion

    //region Test Overflow
    @Test @Ignore
    public void shouldLogPositiveIntOverflow() {
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();

        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    @Test @Ignore
    public void shouldLogNegativeIntOverflow()  throws IOException {
        Logger.log(-13);
        Logger.log(-19);
        Logger.log(Integer.MIN_VALUE);
        Logger.log(-6);
        Logger.flush();

        assertSysoutContains("-32");
        assertSysoutContains(String.valueOf(Integer.MIN_VALUE));
        assertSysoutContains("-6");
    }

    @Test @Ignore
    public void shouldLogPositiveByteOverflow() {
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();

        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Byte.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    @Test @Ignore
    public void shouldLogNegativeByteOverflow()  throws IOException {
        Logger.log((byte)-13);
        Logger.log((byte)-19);
        Logger.log(Byte.MIN_VALUE);
        Logger.log((byte)-6);
        Logger.flush();

        assertSysoutContains("-32");
        assertSysoutContains(String.valueOf(Byte.MIN_VALUE));
        assertSysoutContains("-6");
    }
    //endregion
}