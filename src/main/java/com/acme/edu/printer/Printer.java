package com.acme.edu.printer;

import com.acme.edu.message.DataEqualMessage;

public class Printer {

    MessageDecorator decorator;

    public void getMessage(DataEqualMessage message){
        print(message.toString());
    }

    private void print(String message){
        System.out.println(message);
    }
}
