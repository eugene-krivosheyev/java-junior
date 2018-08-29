package com.acme.edu.decorator;

import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;

public class DefaultStringDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        String text = ((StringMessage)message).getMessage();
        int countOfStrings = ((StringMessage)message).getCountOfStrings();
        return "string: " + text + (countOfStrings > 1 ? " (x" + countOfStrings + ')' : "");
    }

}
