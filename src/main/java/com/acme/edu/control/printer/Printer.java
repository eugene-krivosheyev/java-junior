package com.acme.edu.control.printer;

import com.acme.edu.control.message.Message;

public class Printer {

    public void save(Message message){
        print(message.toString());
    }

    private void print(String message){
        System.out.println(message);
    }
}
