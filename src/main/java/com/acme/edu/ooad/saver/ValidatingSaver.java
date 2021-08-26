package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.message.ObjectMessage;

public class ValidatingSaver implements Saver {

    @Override
    public void save(ObjectMessage message) {
        if ( message == null ||
             message.toString().isEmpty() ) throw new IllegalArgumentException("Logged message must be not empty!");
    }
}
