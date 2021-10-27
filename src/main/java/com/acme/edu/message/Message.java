package com.acme.edu.message;

import java.util.List;

public interface Message {

    Message[] append(Message message);

    String getBody();

    boolean canAppend(Message message);
}
