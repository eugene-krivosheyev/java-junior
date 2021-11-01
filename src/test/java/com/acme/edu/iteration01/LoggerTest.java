package com.acme.edu.iteration01;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.TypeCodeEnum;
import com.acme.edu.logger.SimpleLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private static String type;
    private final SimpleLogger logger = new SimpleLogger();

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
    public void shouldLogInteger() throws IOException {
        type = TypeCodeEnum.INTEGER.getTypeReference();
        //region when
        logger.log(1, 0, -1);
        //endregion

        //region then
        checkLog("1", "0", "-1");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        type = TypeCodeEnum.BYTE.getTypeReference();
        //region when
        logger.log((byte) 1, (byte) 0, (byte) -1);
        //endregion

        //region then
        checkLog("1", "0", "-1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        type = TypeCodeEnum.CHAR.getTypeReference();
        //region when
        logger.log('a', 'b');
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
        logger.log(str1, str2);
        //endregion

        //region then
        checkLog(str1, str2);
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        type = TypeCodeEnum.BOOLEAN.getTypeReference();
        //region when
        logger.log(true, false);
        //endregion

        //region then
        checkLog("true", "false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        type = TypeCodeEnum.NONE.getTypeReference();
        //region when
        logger.log(new Object());
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
}