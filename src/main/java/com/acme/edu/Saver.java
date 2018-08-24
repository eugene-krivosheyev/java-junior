package com.acme.edu;

import com.acme.edu.message.Message;

public class Saver {
    public void save(Message message) {
        System.out.println(message.getDecoratedString());
    }
}
