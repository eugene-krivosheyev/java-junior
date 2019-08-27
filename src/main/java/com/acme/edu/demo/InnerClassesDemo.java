package com.acme.edu.demo;

import com.acme.edu.ooaddemo2.*;

public class InnerClassesDemo {
    public static void main(String[] args) {
        SuperConsoleSaver s = new SuperConsoleSaver();
        new LoggerController(
                command -> "WTF".equals(command.getMessage()),
                s::save
        );
    }
}