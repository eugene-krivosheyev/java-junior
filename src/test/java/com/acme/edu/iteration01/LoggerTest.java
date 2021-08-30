package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.Prefix;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.saver.SaveException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//@Disabled("Disabled to count unit tests coverage.")
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
    public void shouldLogInteger() throws SaveException {
        //region when
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(Prefix.PRIMITIVE.value + " 1");
        assertSysoutContains(Prefix.PRIMITIVE.value + " 0");
        assertSysoutContains(Prefix.PRIMITIVE.value + " -1");
        //endregion
    }

    @Test
    public void shouldLogByte() throws SaveException {
        //region when
        Logger.log((byte)1);
        Logger.flush();
        Logger.log((byte)0);
        Logger.flush();
        Logger.log((byte)-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(Prefix.PRIMITIVE.value);
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogChar() throws SaveException {
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
    public void shouldLogString() throws SaveException {
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
    public void shouldLogBoolean() throws SaveException {
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
    public void shouldLogReference() throws SaveException {
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