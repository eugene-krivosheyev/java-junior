package com.acme.edu.saver;

import com.acme.edu.message.Message;

public class ConsoleSaver implements Saver{
    public void save(Message toLog){
        System.out.println(toLog);
    }

}
