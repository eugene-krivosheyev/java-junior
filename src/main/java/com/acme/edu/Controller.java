package com.acme.edu;


import com.acme.edu.processors.Message;

public class Controller {
    private Message currentState;
    public void log(Message message){
        if(!currentState.isSameType(message)){
            currentState.flush();
            currentState = message;
        } else {
            currentState = currentState.accumulate(message);
        }
    }
}
