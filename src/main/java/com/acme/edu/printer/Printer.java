package com.acme.edu.printer;

import com.acme.edu.message.Message;

public class Printer {

    MessageDecorator decorator;

    public void getMessage(Message message){
        print(message.toString());
    }

    private void print(String message){
        System.out.println(message);
    }
}
