package com.acme.edu.testing;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.decorator.Decorator;
import com.acme.edu.decorator.PrefixDecorator;
import com.acme.edu.message.Message;
import com.acme.edu.message.StartMessage;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;
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
        Saver saver = new ConsoleSaver();
        Decorator decorator = new PrefixDecorator();
        Message message = new StartMessage(saver, decorator);
        Logger logger = new Logger(message, saver, decorator);
        try {
            logger.log(1);
            logger.flush();

        } catch (Exception e) {

        }
        assertSysoutEquals("primitive: 1" + System.lineSeparator());
    }

    @Test
    public void checkSimpleString() {

        Saver saver = new ConsoleSaver();
        Decorator decorator = new PrefixDecorator();
        Message message = new StartMessage(saver, decorator);
        Logger logger = new Logger(message, saver, decorator);
        try {
            logger.log("str 1");
            logger.flush();

        } catch (Exception e) {

        }
        assertSysoutContains("str 1" + System.lineSeparator());
    }

    @Test
    public void checkSequenceInt() {
        Saver saver = new ConsoleSaver();
        Decorator decorator = new PrefixDecorator();
        Message message = new StartMessage(saver, decorator);
        Logger logger = new Logger(message, saver, decorator);
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
        Saver saver = new ConsoleSaver();
        Decorator decorator = new PrefixDecorator();
        Message message = new StartMessage(saver, decorator);Logger logger = new Logger(message, saver, decorator);
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