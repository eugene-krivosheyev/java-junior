package com.acme.edu.controller;

import com.acme.edu.message.Message;
import com.acme.edu.saver.SaveException;
import com.acme.edu.saver.SimpleSaver;

import static java.util.Objects.isNull;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class Controller {

    private Message currentMessage;
    private SimpleSaver saver = new SimpleSaver();

    public int log(Message message) throws LogOperationException {

        LogOperationException exception = null;

        if (isNull(currentMessage)){
            currentMessage = message;
            return 0;
        }

        if (currentMessage.isSameTypeOf(message)){
            currentMessage.accumulate(message);
            return 0;
        }
        else{
            String decoratedMessage = currentMessage.getDecoratedMessage();
            try {
            saver.save(decoratedMessage);
            }
            catch (SaveException e){
                e.printStackTrace();
                exception = new LogOperationException("Your output is null", e, 228);
                throw exception;
            }
            finally {
                if (isNull(exception)){
                    this.currentMessage = message;
                    return 0;
                } else {
                    return exception.getCode();
                }

            }

        }

    }

    public void flush() {
        if (!isNull(currentMessage)) {
            System.out.println(currentMessage.getDecoratedMessage());
        }
        currentMessage = null;
    }

    public void setCurrentMessage(Message message) {
        this.currentMessage = message;
    }
}