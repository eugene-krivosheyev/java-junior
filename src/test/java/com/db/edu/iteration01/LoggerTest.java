package com.db.edu.iteration01;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.db.edu.Logger.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @BeforeEach
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    @Disabled
    public void shouldLogInteger() throws AssertionError {
        //region when
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
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
    @Disabled
    public void shouldLogByte() throws AssertionError {
        //region when
        Logger.log((byte)1);
        Logger.log((byte)0);
        Logger.log((byte)-1);
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
    @Disabled
    public void shouldLogChar() throws AssertionError {
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
    @Disabled
    public void shouldLogString() throws AssertionError {
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
    @Disabled
    public void shouldLogBoolean() throws AssertionError {
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
    @Disabled
    public void shouldLogReference() throws AssertionError {
        //region when
        Logger.log(new Object());
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(REFERENCE_PREFIX);
        assertSysoutContains("@");
        //endregion
    }
}