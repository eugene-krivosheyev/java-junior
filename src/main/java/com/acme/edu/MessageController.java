package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.savers.ConsolePrinter;
import com.acme.edu.savers.MessageSaver;

public class MessageController {
    private Message mess;

    public MessageController(Message mess) {
        this.mess = mess;
    }
    public void flush(){
        if(!mess.isUsed()){

            Object message = Flusher.getBuffer();
            boolean isUsed = Flusher.isUsage();
            int counter = Flusher.getCounter();
            //MessageFormatter formater = new MessageFprmatter()
            MessageSaver saver = new ConsolePrinter();
            mess.flush();
        }
    }
    public void accumulate(){
        mess.accumulate();
    }


    public static void overFlush(byte needToFlush){
        System.out.println(needToFlush);
    }
    public static void overFlush(int needToFlush){
        System.out.println(needToFlush);
    }
}
