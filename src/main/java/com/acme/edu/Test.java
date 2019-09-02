package com.acme.edu;

import com.acme.edu.mylogger.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        Client.main(new String[] {"Integer 1"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"Integer 1"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"Integer 1"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"Integer " + Integer.MAX_VALUE});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"Integer 1"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"Integer 1"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"Integer 1"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"Flush"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"String str1"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"String str2"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"String str2"});
        TimeUnit.SECONDS.sleep(1);
        Client.main(new String[] {"Flush"});
/*
        LoggerController loggerController = new LoggerController(
                new SuperCurrentAccumulator(), new SuperFileSaver("logger.txt"));
        loggerController.log(new StringCommand("str 1"));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(Integer.MAX_VALUE - 3));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(7));
        loggerController.log(new IntCommand(Integer.MAX_VALUE - 400));
        loggerController.log(new IntCommand(5));
        loggerController.flush();
        loggerController.log(new StringCommand("str 1"));
        loggerController.log(new StringCommand("str 2"));
        loggerController.log(new StringCommand("str 1"));
        loggerController.log(new StringCommand("str 1"));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(Integer.MAX_VALUE));
        loggerController.log(new ByteCommand((byte)1));
        loggerController.log(new ByteCommand((byte)1));
        loggerController.log(new ByteCommand(Byte.MAX_VALUE));
        loggerController.log(new CharCommand('a'));
        loggerController.log(new CharCommand('a'));
        loggerController.log(new CharCommand('a'));
        loggerController.flush();
*/
    }

}
