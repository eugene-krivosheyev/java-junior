package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.dto.StatesDTO;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.TypeCodeEnum;
import com.acme.edu.flush.Flusher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private static String type;
    private final Logger logger;
    private final StatesDTO statesDTO;
    private final Flusher flusher;

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
    public void shouldLogInteger() throws IOException {
        type = TypeCodeEnum.INTEGER.getTypeReference();
        //region when
        log(1, 0, -1);
        //endregion

        //region then
        checkLog("1", "0", "-1");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        type = TypeCodeEnum.BYTE.getTypeReference();
        //region when
        log((byte) 1, (byte) 0, (byte) -1);
        //endregion

        //region then
        checkLog("1", "0", "-1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        type = TypeCodeEnum.CHAR.getTypeReference();
        //region when
        log('a', 'b');
        //endregion

        //region then
        checkLog("a", "b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        type = TypeCodeEnum.STRING.getTypeReference();
        String str1 = "first string";
        String str2 = "second string";
        //region when
        log(str1, str2);
        //endregion

        //region then
        checkLog(str1, str2);
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        type = TypeCodeEnum.BOOLEAN.getTypeReference();
        //region when
        log(true, false);
        //endregion

        //region then
        checkLog("true", "false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        type = TypeCodeEnum.NONE.getTypeReference();
        //region when
        log(new Object());
        //endregion

        //region then
        assertSysoutContains(type);
        assertSysoutContains("@");
        //endregion
    }

    private void checkLog(String... valuesToCheck) throws IOException {
        for (String valueToCheck : valuesToCheck) {
            assertSysoutContains(type + valueToCheck);
        }
    }

    private void log(Object... valuesToLog) throws IOException {
        for (Object valueToLog : valuesToLog) {
            logger.log(valueToLog);
            flusher.flush(statesDTO);
        }
    }
}