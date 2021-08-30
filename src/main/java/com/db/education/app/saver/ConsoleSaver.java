package com.db.education.app.saver;

import com.db.education.app.exception.SaveException;
import com.db.education.app.message.Message;

public class ConsoleSaver implements Saver {

    public void save(Message message) throws SaveException {
        try {
            if (message == null) {
                throw new NullPointerException("FATAL ERROR: received null instead of message");
            }
        } catch (NullPointerException npe) {
            throw new SaveException("Message was not saved! " + npe.getMessage(), npe);
        }

        System.out.print(message);
    }
}
