package com.acme.edu;

public class Test {
    public static void main(String[] args) {
        LoggerController logger = new LoggerController(new SuperCurrentAccumulator(), new SuperConsoleSaver());
        //IntCommand command = new IntCommand(1);
        logger.log(new IntCommand(1));
        logger.log(new IntCommand(2));
        logger.log(new IntCommand(Integer.MAX_VALUE));
        logger.log(new StringCommand("str 1"));
        logger.log(new IntCommand(1));
        logger.log(new StringCommand("str 2"));
        logger.flush();

        logger.log(new ByteCommand((byte)1));
        logger.log(new ByteCommand((byte)2));
        logger.log(new ByteCommand(Byte.MAX_VALUE));
        logger.log(new StringCommand("str 3"));
        logger.log(new ByteCommand((byte)1));
        logger.log(new StringCommand("str 4"));
        logger.flush();
    }
}
