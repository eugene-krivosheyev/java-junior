package com.acme.edu.ourBranchTests;


import com.acme.edu.ConsolSaver;
import com.acme.edu.Logger;
import com.acme.edu.Saver;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BranchTest implements SysoutCaptureAndAssertionAbility {
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
    public void shouldCorrectLogEmptyString()throws IOException {
        Logger.log("");
        Logger.flush();

        assertSysoutContains("(x1)");
    }


    @Test
    public void shouldLogTwoIntegers() throws IOException {
        //region when
        Logger.log(1);
        Logger.log(2);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: 3");
        //endregion
    }

    @Test
    public void shouldLogTwoDifferentTypes() throws IOException {
        //region when
        Logger.log(1);
        Logger.log("2");
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: 1");
        assertSysoutContains("string: 2");
        //endregion
    }

    @Test
    public void saverNullStringTest() throws IOException {
        //region given
        Saver saver = new Saver();
        String testString = null;
        //endregion

        //region when
        saver.save(testString);
        //endregion

        //region then
        assertSysoutContains("It is null!!!!");
        //endregion
    }



    @Test
    public void saverNotNullStringTest() throws IOException {
        //region given
        Saver saver = new Saver();
        //endregion

        //region when
        saver.save("Test");
        //endregion

        //region then
        assertSysoutEquals("");
        //endregion
    }

    @Test
    public void consoleSaverNullStringTest() throws IOException {
        //region given
        Saver saver = new ConsolSaver();
        String testString = null;
        //endregion

        //region when
        saver.save(testString);
        //endregion

        //region then
        assertSysoutContains("It is null!!!!");
        assertSysoutContains("null");
        //endregion
    }
    @Test
    public void consoleSaverNotNullStringTest() throws IOException {
        //region given
        Saver saver = new ConsolSaver();
        String testString = "test";
        //endregion

        //region when
        saver.save(testString);
        //endregion

        //region then
        assertSysoutEquals("test" + System.lineSeparator());
        //endregion
    }
}
