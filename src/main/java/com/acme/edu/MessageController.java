package com.acme.edu;

import com.acme.edu.message.*;

public class MessageController {
    private Message mess;

    public MessageController(Message mess) {
        this.mess = mess;
    }
    public void flush(){
        if(!mess.isUsed().equals(Flusher.getUsed())){
            Flusher.flush();
             mess.flush();
        }
    }
    public void accumulate(){
        mess.accumulate();
    }
}
