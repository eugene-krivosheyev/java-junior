package com.acme.edu.testing;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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
    public void checkSimpleInt() {

        Logger logger = new Logger();
        try {
            logger.log(1);
            logger.flush();

        } catch (Exception e) {

        }
        assertSysoutEquals("primitive: 1" + System.lineSeparator());
    }

    @Test
    public void checkSimpleString() {

        Logger logger = new Logger();
        try {
            logger.log("str 1");
            logger.flush();

        } catch (Exception e) {

        }
        assertSysoutEquals("str 1" + System.lineSeparator());
    }

    @Test
    public void checkSequenceInt() {

        Logger logger = new Logger();
        try {
            logger.log(1);
            logger.log(2);
            logger.log(3);
            logger.flush();

        } catch (Exception e) {

        }
        assertSysoutEquals("primitive: 6" + System.lineSeparator());
    }

    @Test
    public void checkBrokenSequencesInt() {

        Logger logger = new Logger();
        try {
            logger.log(1);
            logger.log(2);
            logger.log(3);
            logger.flush();
            logger.log(1);
            logger.log(2);
            logger.flush();
        } catch (Exception e) {

        }
        assertSysoutEquals("primitive: 6" + System.lineSeparator() + "primitive: 3" + System.lineSeparator());
    }
}