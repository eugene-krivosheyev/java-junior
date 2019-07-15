package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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
    public void shouldLogInteger() throws IOException {
        //region when
        Logger.log(1);
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
<<<<<<< HEAD
=======
        Logger.log(0);
        Logger.log(-1);
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
=======
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55
        //endregion

        //region then
        assertSysoutContains("primitive: ");
<<<<<<< HEAD
<<<<<<< HEAD
        String newLn = System.lineSeparator();
        assertSysoutEquals("primitive: 1" + newLn + "primitive: 0" + newLn + "primitive: -1" + newLn);
=======
        assertSysoutEquals("primitive: 1\nprimitive: 0\nprimitive: -1\n");
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
=======
        String newLn = System.lineSeparator();
        assertSysoutEquals("primitive: 1" + newLn + "primitive: 0" + newLn + "primitive: -1" + newLn);
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte)1);
        Logger.log((byte)0);
        Logger.log((byte)-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55

=======
    /*
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }
<<<<<<< HEAD
<<<<<<< HEAD
/*
    TODO: implement Logger solution to match specification as tests*/
=======
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
=======
/*
    TODO: implement Logger solution to match specification as tests*/
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
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
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

    */
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
=======
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55
}