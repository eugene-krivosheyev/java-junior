package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.saver.SaveException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled to count unit tests coverage.")
public class LoggerTest implements SysoutCaptureAndAssertionAbility {
  private final String SEPARATOR = System.lineSeparator();

  //region given
  @BeforeEach
  public void setUpSystemOut(){
    resetOut();
    captureSysout();
  }

  @AfterEach
  public void tearDown() {
    resetOut();
  }
  //endregion

    @Test
    public void shouldLogSequentIntegersAsSum() throws SaveException {
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
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws SaveException {
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