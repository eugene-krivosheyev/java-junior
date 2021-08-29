package com.db.education.app.saver;

import com.db.education.app.message.Message;

public class ConsoleSaver implements Saver {

    public void save(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("FATAL ERROR: received null instead of message");
        }
        System.out.print(message.toString());
    }
}
