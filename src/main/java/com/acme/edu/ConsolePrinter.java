package com.acme.edu;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Message message) {
        System.out.println(message.getDecoratedString());
    }
}
