package com.acme.edu.message;

import com.acme.edu.exception.AccumulateException;
import com.acme.edu.exception.DecorateException;

public interface Message {

    Message accumulate(Message message) throws AccumulateException;
    Message decorate() throws DecorateException;
    boolean isInstanceOf(Message message);
    String getDecoratedString();
}
