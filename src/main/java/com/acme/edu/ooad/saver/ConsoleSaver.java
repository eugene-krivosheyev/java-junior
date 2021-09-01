package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;

public class ConsoleSaver extends ValidatingSaver {

    @Override
    public void save(Message message) throws SaveException {
        super.save(message);
        System.out.println(message);
    }
}
