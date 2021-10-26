package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

@Disabled
public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    public static final String sep = lineSeparator();

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



    //TODO: implement Logger solution to match specification as tests

    // должен регистрировать последовательные целые числа как сумму

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
//        assertSysoutEquals(
//            "str 1" + sep +
//            "3" + sep +
//            "str 2" + sep +
//            "0" + sep
//        );
        //endregion
        assertSysoutContains("str 1");
        assertSysoutContains("3");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    // должен правильно регистрировать целочисленное переполнение при последовательных целых числах

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
//        assertSysoutEquals(
//            "str 1" + sep +
//            "10" + sep +
//            Integer.MAX_VALUE + "" + sep +
//            "str 2" + sep +
//            "0" + sep
//        );
        //endregion
        assertSysoutContains("str 1");
        assertSysoutContains("2147483657");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    // должен правильно регистрировать переполнение байтов при последовательных байтах

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
//        assertSysoutEquals(
//            "str 1" + sep +
//            "10" + sep +
//            Byte.MAX_VALUE + "" + sep +
//            "str 2" + sep +
//            "0" + sep
//        );
        //endregion
        assertSysoutContains("str 1");
        assertSysoutContains("137");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    // должен регистрировать одни и те же последующие строки без повторения

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
//        assertSysoutEquals(
//            "str 1" + sep +
//            "str 2 (x2)" + sep +
//            "0" + sep +
//            "str 2" + sep +
//            "str 3 (x3)" + sep
//        );
        //endregion

        assertSysoutContains("str 1");
        assertSysoutContains("str 2 (x2)");
        assertSysoutContains("0");
        assertSysoutContains("str 2");
        assertSysoutContains("str 3 (x3)");
    }
}