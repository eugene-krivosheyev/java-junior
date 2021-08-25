package com.db.edu.iteration02;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static java.lang.System.lineSeparator;

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
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: 3");
        assertSysoutContains("primitive: 0");
        assertSysoutEquals(
            "string: str 1" +lineSeparator()+
            "primitive: 3" + lineSeparator()+
            "string: str 2" + lineSeparator()+
            "primitive: 0" + lineSeparator()
        );
        //endregion
    }
/*
    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion
        //region then
        assertSysoutContains("primitive: 10");
        assertSysoutContains("primitive: "+Integer.MAX_VALUE);
        //endregion
    }*/

/*
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
            "str 1" +lineSeparator()+
            "10" +lineSeparator()+
            Byte.MAX_VALUE + lineSeparator() +
            "str 2" +lineSeparator()+
            "0"+lineSeparator()
        );
        //endregion
    }
*/


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
        Logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" +lineSeparator()+
            "string: str 2 (x2)" +lineSeparator()+
            "primitive: 0" +lineSeparator()+
            "string: str 2" +lineSeparator()+
            "string: str 3 (x3)"+lineSeparator()
        );
        //endregion
    }


}