package com.acme.edu;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;
import com.acme.edu.loggers.IntLogger;
import com.acme.edu.messages.ByteMessage;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.State.Type;
import com.acme.edu.messages.StringMessage;

public class LoggerController {
    IntLogger intLogger = new IntLogger();

    IntMessage intMessage = new IntMessage(0);
    ByteMessage byteMessage = new ByteMessage((byte) 0);
    StringMessage stringMessage = new StringMessage("");

    State state = new State();
    Printer printer = new ConsolePrinter();

    private boolean processPreviousMessage() {
        if (state.getCurrentType().equals(state.getPreviousType())) {
            return false;
        }
        switch (state.getPreviousType()) {
            case STRING:
                printer.print(stringMessage);
                //counter = 0;
                break;
            case INTEGER:
                printer.print(intMessage);
                break;
            case BYTE:
                printer.print(byteMessage);
                break;
        }
        return true;
    }
    public void flush() {
        state.setNextType(Type.UNDEFINED);
        processPreviousMessage();
        stringMessage.clear();
        intMessage.clear();
        byteMessage.clear();
    }

    public void log(int message) {
        state.setNextType(Type.INTEGER);
        if (processPreviousMessage()) {
            intMessage.setValue(message);
        } else {
            if (intMessage.getValue() + (long)message > Integer.MAX_VALUE) {
                // TODO fix overflow logic
                printer.print(intMessage);
                intMessage.setValue(Integer.MAX_VALUE);
                printer.print(intMessage);
            }
            intMessage.setValue(intMessage.getValue() + message);
        }
    }
    public void log(byte message) {
        state.setNextType(Type.BYTE);
        if (processPreviousMessage()) {
            byteMessage.setValue(message);
        } else {
            if (byteMessage.getValue() + (int) message > Byte.MAX_VALUE) {
                // TODO fix overflow logic
                printer.print(byteMessage);
                byteMessage.setValue(Byte.MAX_VALUE);
                printer.print(byteMessage);
            }
            byteMessage.setValue((byte) (byteMessage.getValue() + message));
        }
    }
    public void log(String message) {
        state.setNextType(Type.STRING);
        if (processPreviousMessage()) {
            stringMessage.setValue(message);
        } else {
            stringMessage.process(printer, message);
        }
    }
    public void log(Object message) {

    }
    public void log(char message) {

    }
    public void log(int... message) {

    }
    public void log(int[]... message) {

    }
    public void log(String... message) {

    }
}
