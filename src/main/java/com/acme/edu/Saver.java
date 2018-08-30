package com.acme.edu;

import com.acme.edu.message.Message;

public class Saver {
    public void save(Message message) throws SaveException {
        try {
            System.out.println(message.getDecoratedString());
        } catch (Exception e) {
            throw new SaveException(e);
        }
    }
}
