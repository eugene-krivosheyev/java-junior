package com.acme.edu.iteration06;

import com.acme.edu.Logger;
import com.acme.edu.MessageType;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.decorator.BinaryIntDecorator;
import com.acme.edu.message.decorator.DefaultIntDecorator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
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
    public void shouldLogWithDifferentDecorators() throws IOException {
        //region when
        Logger.log(134);
        Logger.flush();
        Logger.setDecorator(new BinaryIntDecorator());
        Logger.log(5);
        Logger.flush();
        Logger.setDecorator(new DefaultIntDecorator());
        //endregion

        //region then
        assertSysoutContains("134");
        assertSysoutContains("101");
        //endregion
    }

    @Test
    public void shouldAccumulateBytes()  throws IOException {
        Logger.log((byte)5);
        Logger.log((byte)15);
        Logger.log(Byte.MAX_VALUE);
        Logger.log((byte)1);
        Logger.flush();

        assertSysoutContains("20");
        assertSysoutContains(String.valueOf(Byte.MAX_VALUE));
        assertSysoutContains("1");
    }

    @Test
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

    @Test
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
}