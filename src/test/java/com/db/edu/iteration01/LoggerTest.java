package com.db.edu.iteration01;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    public void shouldLogInteger() throws IOException {
        //region when
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + System.lineSeparator() + "primitive: 0" + System.lineSeparator() +
                "primitive: -1" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte) 1);
        Logger.flush();
        Logger.log((byte) 0);
        Logger.flush();
        Logger.log((byte) -1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.log('b');
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger.log(true);
        Logger.log(false);
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}