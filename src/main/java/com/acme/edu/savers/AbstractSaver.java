package com.acme.edu.savers;

import com.acme.edu.checkers.IntSequenceChecker;
import com.acme.edu.checkers.StringSequenceChecker;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.StringMessage;

public abstract class AbstractSaver implements Saver  {
    private StringSequenceChecker stringChecker;
    private IntSequenceChecker intChecker;

    abstract void save(String message) throws SaverException;

    @Override
    public void save(Message message) {
        String accumulatedStr;
        Integer accumulatedInt;

        accumulatedStr = stringChecker.check(message.getValue());
        if (accumulatedStr != null)
            sendToSave( new StringMessage(accumulatedStr).decorate() );

        accumulatedInt = intChecker.check( message.getValue());
        if (accumulatedInt != null)
            sendToSave( new IntMessage(accumulatedInt).decorate() );

        if ( !InstanceOfSpecialTypes(message) ) {
            sendToSave(message.getType() + ": " + message.getValue());
        }
    }

    @Override
    public void setCheckers(IntSequenceChecker intChecker, StringSequenceChecker stringChecker) {
        this.stringChecker = stringChecker;
        this.intChecker = intChecker;
    }

    @Override
    public void flush() {
        String accumulatedStr;
        Integer accumulatedInt;

        accumulatedStr = stringChecker.check(null);
        if (accumulatedStr != null)
            sendToSave(new StringMessage(accumulatedStr).decorate());

        accumulatedInt = intChecker.check(null);
        if (accumulatedInt != null)
            sendToSave(new IntMessage(accumulatedInt).decorate());
    }

    private boolean InstanceOfSpecialTypes(Message message) {
        return (message instanceof StringMessage ||
                message instanceof IntMessage);
    }

    private void sendToSave(String message) {
        if (message.equals("")) return;

        try {
            save(message);
        } catch (SaverException ex) {
            System.out.println("exception: " + ex.getMessage());
        }
    }
}
