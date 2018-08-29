package com.acme.edu.decorator;

import com.acme.edu.message.Message;

public interface LoggerDecorator {
    String decorate(Message message);
}
