package com.acme.edu.message;

import java.util.ArrayList;

public abstract class AbstractMessage {
    static public String PREFIX = "";
    public StringBuilder messageController = new StringBuilder();

    public abstract void prepareMessage(ArrayList<Object> listOfLog);
}
