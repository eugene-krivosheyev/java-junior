package com.acme.edu.saver;

import com.acme.edu.exception.SaveException;
import com.acme.edu.message.Message;

public class ConsoleSaver implements Saver {
    public void save(Message message) throws SaveException {
        try {
            System.out.println(message.getDecoratedString());
        } catch (Exception e) {
            throw new SaveException(e);
        }
    }
}
