package com.db.edu.Message;

import com.db.edu.Save.ConsoleSaver;
import com.db.edu.Prefix;

public class CharMessage implements Message {
    private char messageBody;

    public CharMessage(char messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String decorate() {
        return Prefix.CHAR.value + messageBody;
    }


    @Override
    public void accumulate(Message message) {

    }

    @Override
    public void close() {
    }
}
