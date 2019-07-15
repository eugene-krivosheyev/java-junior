package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

<<<<<<< HEAD
<<<<<<< HEAD
import static java.lang.System.lineSeparator;

=======
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
=======
import static java.lang.System.lineSeparator;

>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55
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


<<<<<<< HEAD
<<<<<<< HEAD

=======
    /*
    TODO: implement Logger solution to match specification as tests
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
=======

>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
<<<<<<< HEAD
<<<<<<< HEAD
        Logger.flush();
        //endregion

        //region then
        String newLine = lineSeparator();
        assertSysoutEquals(
            "str 1" + newLine +
            "3" + newLine +
            "str 2" + newLine +
            "0" + newLine
=======
=======
        Logger.flush();
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55
        //endregion

        //region then
        String newLine = lineSeparator();
        assertSysoutEquals(
<<<<<<< HEAD
            "str 1\n" +
            "3\n" +
            "str 2\n" +
            "0\n"
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
=======
            "str 1" + newLine +
            "3" + newLine +
            "str 2" + newLine +
            "0" + newLine
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55
        );
        //endregion
    }

<<<<<<< HEAD
<<<<<<< HEAD
    /*
    TODO: implement Logger solution to match specification as tests
=======
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
=======
    /*
    TODO: implement Logger solution to match specification as tests
>>>>>>> d3419244d7223707567d749c12b1a86158ce4e55
    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "10\n" +
            Integer.MAX_VALUE + "\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "10\n" +
            Byte.MAX_VALUE + "\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)\n"
        );
        //endregion
    }

    */
}