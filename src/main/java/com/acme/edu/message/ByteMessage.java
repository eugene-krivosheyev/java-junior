package com.acme.edu.message;

import com.acme.edu.ConsoleSaver;
import com.acme.edu.Prefix;

public class ByteMessage extends Message{
    private final byte body;

    public ByteMessage(byte body) {
        super(body);

        this.body = body;
    }

    @Override
    public void writeMessageToLog(){
        String result = String.format("%s %s%n", Prefix.PRIMITIVE.value, body);
        ConsoleSaver.writeToConsole(result);
    }
}
