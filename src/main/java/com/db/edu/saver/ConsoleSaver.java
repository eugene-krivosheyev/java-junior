package com.db.edu.saver;

import com.db.edu.messagepack.message.Message;

public class ConsoleSaver implements Saver {
    @Override
    public void save(Message message) throws SaveException {
        try {
            if(message == null) {
                throw new NullPointerException("ConsoleSaver: Empty message is received");
            }
            System.out.println(message.getDecoratedMessage());
        } catch (NullPointerException npe) {
            throw new SaveException(npe);
        }
    }
}
