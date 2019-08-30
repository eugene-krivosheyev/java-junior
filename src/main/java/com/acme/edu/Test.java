package com.acme.edu;

import com.acme.edu.mylogger.*;

public class Test {

    public static void main(String[] args) {
        //LoggerController loggerController = new LoggerController(
        //        new SuperCurrentAccumulator(), new SuperConsoleSaver());
        LoggerController loggerController = new LoggerController(
                new SuperCurrentAccumulator(), new SuperFileSaver());
        loggerController.log(new IntCommand(1));
        //loggerController.flush();
        //loggerController.log(new IntCommand(Integer.MAX_VALUE));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(1));
        //loggerController.flush();
        loggerController.log(new IntCommand(Integer.MAX_VALUE - 3));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(7));
        loggerController.log(new IntCommand(Integer.MAX_VALUE - 400));
        loggerController.log(new IntCommand(5));
        //loggerController.flush();
        //loggerController.log(new IntCommand(1));
        //loggerController.log(new IntCommand(1));
        loggerController.log(new StringCommand("str 1"));
        loggerController.log(new StringCommand("str 2"));
        loggerController.log(new StringCommand("str 1"));
        loggerController.log(new StringCommand("str 1"));
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(Integer.MAX_VALUE));
        //loggerController.flush();
        loggerController.log(new ByteCommand((byte)1));
        loggerController.log(new ByteCommand((byte)1));
        loggerController.log(new ByteCommand(Byte.MAX_VALUE));
        loggerController.log(new CharCommand('a'));
        loggerController.log(new CharCommand('a'));
        loggerController.log(new CharCommand('a'));
        loggerController.flush();
    }
}
