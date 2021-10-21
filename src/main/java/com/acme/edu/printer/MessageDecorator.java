package com.acme.edu.printer;

import com.acme.edu.message.Message;

public interface MessageDecorator {
    String decorate(Message message);
}
