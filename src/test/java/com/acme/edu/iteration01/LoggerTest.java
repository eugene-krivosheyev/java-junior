package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

@Ignore
public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private int counter = 0;
    //region given
    @Before @Ignore
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After @Ignore
    public void tearDown() {
        resetOut();
        //System.out.println(counter);
    }
    //endregion

    @Test @Ignore
    public void shouldLogInteger() throws IOException {
        //region when
        Logger.log(1);
        Logger.log(0);
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("primitive: 1" + System.getProperty("line.separator") + "primitive: 0" + System.getProperty("line.separator") + "primitive: -1" + System.getProperty("line.separator"));
        //endregion

        counter++;
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte)1);
        Logger.log((byte)0);
        Logger.log((byte)-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
        counter++;
    }


    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.log('b');
        Logger.flush();
        System.out.println(counter);
        //endregion

        //region then
        assertSysoutContains("0");
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
        counter++;
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
        counter++;
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
        counter++;
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

        counter++;
    }

}
