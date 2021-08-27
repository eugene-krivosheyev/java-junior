package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.message.Message;

public class ValidatingSaver implements Saver {

    @Override
    public void save(Message message) {
        if ( message == null ||
             message.toString().isEmpty() ) throw new IllegalArgumentException("Logged message must be not empty!");
    }
}
