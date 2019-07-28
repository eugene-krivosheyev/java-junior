package com.acme.edu.command;

import java.util.Map;
import java.util.HashMap;

public interface Command<T> {
    String process(Map<String, Boolean> commandParameters, Command previousCommand);
    T getMessage();
    String flush();
    int getCounter();
}
