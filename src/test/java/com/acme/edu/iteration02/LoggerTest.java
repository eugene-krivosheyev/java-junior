package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.dto.StatesDTO;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.flush.Flusher;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private final Flusher flusher;
    private final Logger logger;
    private final StatesDTO statesDTO;

    public LoggerTest() {
        this.flusher = new Flusher();
        this.statesDTO = new StatesDTO(flusher);
        this.logger = new Logger(statesDTO);
    }

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
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        log("str 1", 1, 2, "str 2", 0);
        //endregion

        //region then
        checkLog("str 1", "3", "str 2", "0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws IOException {
        //region when
        log("str 1", 10, Integer.MAX_VALUE, "str 2", 0);
        //endregion

        //region then
        checkLog("str 1", Integer.toString(Integer.MAX_VALUE), "10", "str 2", "0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws IOException {
        //region when
        log("str 1", (byte) 10, Byte.MAX_VALUE, "str 2", 0);
        //endregion

        //region then
        checkLog("str 1", Byte.toString(Byte.MAX_VALUE), "10", "str 2", "0");
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        log("str 1", "str 2", "str 2", 0, "str 2", "str 3", "str 3", "str 3");
        //endregion

        //region then
        checkLog("str 1", "str 2 (x2)", "0", "str 2", "str 3 (x3)");
        //endregion
    }

    private void checkLog(String... valuesToCheck) {
        for (String valueToCheck : valuesToCheck) {
            assertSysoutContains(valueToCheck);
        }
    }

    private void log(Object... valuesToLog) throws IOException {
        for (Object valueToLog : valuesToLog) {
            if (valueToLog.getClass() == Byte.class) {
                logger.log(new ByteMessage((byte) valueToLog));
            } else if (valueToLog.getClass() == Integer.class) {
                logger.log(new IntMessage((int) valueToLog));
            } else if (valueToLog.getClass() == String.class) {
                logger.log(new StringMessage((String) valueToLog));
            }
        }
        flusher.flush(statesDTO);
    }
}