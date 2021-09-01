package com.db.edu.saver;

import com.db.edu.messagepack.message.Message;

public class ConsoleSaver implements Saver {
    @Override
    public void save(Message message) {
        if(message == null) throw new IllegalArgumentException("ConsoleSaver: Empty message is received");
        System.out.println(message.getDecoratedMessage());
    }
}
