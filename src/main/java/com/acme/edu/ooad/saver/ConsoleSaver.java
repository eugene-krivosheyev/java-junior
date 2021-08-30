package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;
import com.acme.edu.ooad.message.ObjectMessage;

public class ConsoleSaver extends ValidatingSaver {

    @Override
    public void save(Message message) throws SaveException {
        try {
            super.save(message);
            System.out.println(message);
        } catch (SaveException e) {
            throw e;
        }
    }
}
