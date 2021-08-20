package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
  private final String SEPARATOR = System.lineSeparator();

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
    public void shouldLogSequentIntegersAsSum() {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1" + SEPARATOR);
        assertSysoutContains("3" + SEPARATOR);
        assertSysoutContains("str 2" + SEPARATOR);
        assertSysoutContains("0" + SEPARATOR);
        //endregion
    }

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
        assertSysoutContains("str 1" + SEPARATOR);
        assertSysoutContains("10" + SEPARATOR);
        assertSysoutContains(Integer.MAX_VALUE + SEPARATOR);
        assertSysoutContains("str 2" + SEPARATOR);
        assertSysoutContains("0" + SEPARATOR);
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
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1" + SEPARATOR);
        assertSysoutContains("10" + SEPARATOR);
        assertSysoutContains(Byte.MAX_VALUE + SEPARATOR);
        assertSysoutContains("str 2" + SEPARATOR);
        assertSysoutContains("0" + SEPARATOR);
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() {
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
        assertSysoutContains("str 1" + SEPARATOR);
        assertSysoutContains("str 2 (x2)" + SEPARATOR);
        assertSysoutContains("0" + SEPARATOR);
        assertSysoutContains("str 2" + SEPARATOR);
        assertSysoutContains("str 3 (x3)" + SEPARATOR);
        //endregion
    }
}