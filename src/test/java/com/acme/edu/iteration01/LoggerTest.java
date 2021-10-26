package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    String type = null;
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
        type = "primitive: ";
        //region when
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(type + 1);
        assertSysoutContains(type + 0);
        assertSysoutContains(type + -1);
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        type = "primitive: ";
        //region when
        Logger.log((byte)1);
        Logger.flush();
        Logger.log((byte)0);
        Logger.flush();
        Logger.log((byte)-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(type + 1);
        assertSysoutContains(type + 0);
        assertSysoutContains(type + -1);
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        type = "char: ";
        //region when
        Logger.log('a');
        Logger.log('b');
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(type + "a");
        assertSysoutContains(type + "b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        type = "string: ";
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(type + "test string 1");
        assertSysoutContains(type + "other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        type = "primitive: ";
        //region when
        Logger.log(true);
        Logger.log(false);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(type + "true");
        assertSysoutContains(type + "false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        type = "reference: ";
        //region when
        Logger.log(new Object());
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(type);
        assertSysoutContains("@");
        //endregion
    }
}