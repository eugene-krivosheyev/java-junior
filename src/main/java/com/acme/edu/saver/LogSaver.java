package com.acme.edu.saver;

import com.acme.edu.message.AbstractMessage;

public class LogSaver implements Saver {
    @Override
    public void save(AbstractMessage message) {
        System.out.println(message.getPreparedMessage());
    }
}
