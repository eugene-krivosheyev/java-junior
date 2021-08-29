package com.db.edu.saver;

import com.db.edu.messagepack.message.Message;

public class ConsoleSaver implements Saver {
    public void save(Message message) {
        System.out.println(message.getDecoratedMessage());
    }
}
