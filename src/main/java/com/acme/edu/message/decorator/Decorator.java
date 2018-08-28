package com.acme.edu.message.decorator;

import com.acme.edu.message.Message;

public interface Decorator {
    String decorate(Message message);
}
