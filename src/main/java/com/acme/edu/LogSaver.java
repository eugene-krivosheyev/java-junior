package com.acme.edu;

import com.acme.edu.message.AbstractMessage;

public class LogSaver {
    public void save(String prefix, Object message) {
        System.out.println(prefix + message);
    }

//    public void save(AbstractMessage message) {
//        System.out.println(message.messageController.toString());
//    }
}
