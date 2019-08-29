package com.acme.edu.mylogger;

public class Test {

    public static void main(String[] args) {
        LoggerController loggerController = new LoggerController(new SuperCurrentAccumulator(), new SuperConsoleSaver());
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(1));
        loggerController.log(new StringCommand("str"));
        loggerController.log(new StringCommand("str"));
        loggerController.log(new IntCommand(Integer.MAX_VALUE));
        loggerController.log(new IntCommand(1));
        loggerController.flush();
        loggerController.log(new ByteCommand((byte)1));
        loggerController.log(new ByteCommand((byte)1));
        loggerController.log(new ByteCommand((byte)1));
        loggerController.flush();
    }
}
