package com.acme.edu.messages;

import com.acme.edu.Printer;

import java.util.Objects;

public class StringMessage implements Message {
    private static String bufferString;
    private static int stringCounter;
    private static String messagePrefix = "string: ";
    private String messageValue;

    public StringMessage(String message){
        this.messageValue = message;
    }

    @Override
    public Message accumulate(Message message) {
        if (Objects.equals(messageValue, ((StringMessage)message).messageValue)) {
            stringCounter+=1;

        } else {
            flush();

        }
        return  message;
    }

    @Override
    public boolean isSameType(Message message) {
        boolean isSameType = message instanceof StringMessage;
        return isSameType;
    }

    @Override
    public String getBody() {
        return messagePrefix + messageValue;
    }

    @Override
    public void flush() {
        Printer.print(stringCounter == 1 ? getBody() : getBody() + " (x" + stringCounter + ")");
        stringCounter =1;
    }

    @Override
    public void init() {
      bufferString = messageValue;
      stringCounter = 1;

    }


}
