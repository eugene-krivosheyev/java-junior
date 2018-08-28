package com.acme.edu.iteration06;

import com.acme.edu.Logger;
import com.acme.edu.MessageType;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.decorator.BinaryIntDecorator;
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
        Logger.setDecorator(MessageType.INT, new BinaryIntDecorator());
        Logger.log(5);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("134");
        assertSysoutContains("101");
        //endregion
    }
}