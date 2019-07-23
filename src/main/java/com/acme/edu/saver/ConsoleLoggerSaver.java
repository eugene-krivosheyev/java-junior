package com.acme.edu.saver;

import java.io.IOException;

public class ConsoleLoggerSaver{
    public void save(String message) throws IOException{
        System.out.println(message);
    }
}
