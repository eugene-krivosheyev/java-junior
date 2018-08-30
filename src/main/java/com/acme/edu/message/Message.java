package com.acme.edu.message;

import com.acme.edu.AccumulateException;
import com.acme.edu.DecorateException;

public interface Message {

    Message accumulate(Message message) throws AccumulateException;
    Message decorate() throws DecorateException;
    boolean isInstanceOf(Message message);
    String getDecoratedString();
}
