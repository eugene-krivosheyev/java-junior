package com.acme.edu.testing;

import com.acme.edu.Logger;
import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.decorator.Decorator;
import com.acme.edu.decorator.PrefixDecorator;
import com.acme.edu.message.Message;
import com.acme.edu.message.StartMessage;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverToLambda;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.rmi.runtime.Log;

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

    @Before
    public void initializeTest () {
        Saver saver = new ConsoleSaver();
        Decorator decorator = new PrefixDecorator();

        Logger.setSaver(saver);
        Logger.setDecorator(decorator);

        Message message = new StartMessage(saver, decorator);

//        () -> new Saver()


        LoggerController loggerController = new LoggerController(
            message,
                messageToPrint -> System.out.print(messageToPrint),
               // System.out::print,
            decorator
        );
        Logger.setLoggerController(loggerController);
    }

    @Test
    public void checkSimpleInt() {
        try {
            Logger.log(1);
            Logger.flush();
        } catch (Exception e) {

        }
        assertSysoutEquals("primitive: 1" + System.lineSeparator());
    }
    @Test
    public void checkSimpleString() {

       /* Saver saver = new ConsoleSaver();
        Decorator decorator = new PrefixDecorator();
        Message message = new StartMessage(saver, decorator);
        Logger logger = new Logger(message, saver, decorator);*/
        try {
            Logger.log("str 1");
            Logger.flush();

        } catch (Exception e) {

        }
        assertSysoutContains("str 1" + System.lineSeparator());
    }

    @Test
    public void checkSequenceInt() {
  /*      Saver saver = new ConsoleSaver();
        Decorator decorator = new PrefixDecorator();
        Message message = new StartMessage(saver, decorator);
        Logger logger = new Logger(message, saver, decorator);*/
        try {
            Logger.log(1);
            Logger.log(2);
            Logger.log(3);
            Logger.flush();

        } catch (Exception e) {

        }
        assertSysoutEquals("primitive: 6" + System.lineSeparator());
    }

    @Test
    public void checkBrokenSequencesInt() {
      /*  Saver saver = new ConsoleSaver();
        Decorator decorator = new PrefixDecorator();
        Message message = new StartMessage(saver, decorator);Logger logger = new Logger(message, saver, decorator);*/
        try {
            Logger.log(1);
            Logger.log(2);
            Logger.log(3);
            Logger.flush();
            Logger.log(1);
            Logger.log(2);
            Logger.flush();
        } catch (Exception e) {

        }
        assertSysoutEquals("primitive: 6" + System.lineSeparator() + "primitive: 3" + System.lineSeparator());
    }
}