package com.db.education.app.Iteration1;

import com.db.education.app.Logger;
import com.db.education.app.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    public static final String CHAR_PREFIX = "char";
    public static final String OBJECT_PREFIX = "reference";
    public static final String PRIMITIVE_PREFIX = "primitive";
    public static final String STRING_PREFIX = "string";

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
        String sep = System.lineSeparator();
        assertSysoutEquals(PRIMITIVE_PREFIX + ": 1" + sep +
                PRIMITIVE_PREFIX + ": 0" + sep + PRIMITIVE_PREFIX + ": -1" + sep);
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
        assertSysoutContains(PRIMITIVE_PREFIX);
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
        assertSysoutContains(CHAR_PREFIX);
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
        assertSysoutContains(STRING_PREFIX);
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
        assertSysoutContains(PRIMITIVE_PREFIX);
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        Logger.flush();
        //endsregion

        //region then
        assertSysoutContains(OBJECT_PREFIX);
        assertSysoutContains("@");
        //endregion
    }

}