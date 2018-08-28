package com.acme.edu;

import com.acme.edu.message.FlushMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.EmptyDecorator;
import com.acme.edu.saver.DefaultSaver;
import com.acme.edu.saver.Saver;

public class Controller {
    private Saver defaultSaver = new DefaultSaver();
    private Message prevMessage = new FlushMessage();
    private Decorator prevDecorator = new EmptyDecorator();

    public void log(Message message, Decorator decorator) {
        if (prevMessage.isAbleToAccumulate(message)) {
            prevMessage = prevMessage.accumulate(message);
        } else {
            defaultSaver.save(prevMessage.decorate(prevDecorator));
            prevMessage = message;
            prevDecorator = decorator;
        }
    }
}
