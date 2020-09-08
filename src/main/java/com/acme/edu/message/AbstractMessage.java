package com.acme.edu.message;

import java.util.ArrayList;

public interface AbstractMessage {
    static public String PREFIX = "";
    public StringBuilder messageController = new StringBuilder();

    public void prepareMessage(ArrayList<Object> listOfLog);
}
