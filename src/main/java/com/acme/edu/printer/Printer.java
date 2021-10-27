package com.acme.edu.printer;

import com.acme.edu.message.DataEqualMessage;

public class Printer {

    MessageDecorator decorator;

    public void getMessage(DataEqualMessage message){
        print(message.toString());
    }

    public void print(String message){
        System.out.println(message);
    }
}
