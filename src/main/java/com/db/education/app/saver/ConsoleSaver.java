package com.db.education.app.saver;

import com.db.education.app.message.Message;

public class ConsoleSaver implements Saver {
    public void save(Message message){
        System.out.print(message.toString());
    }
}
