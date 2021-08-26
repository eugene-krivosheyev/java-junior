package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.message.Message;
import com.acme.edu.ooad.message.ObjectMessage;

public class ConsoleSaver extends ValidatingSaver {

    @Override
    public void save(Message message) {
        try {
            super.save(message);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(message);

    }
}
