package com.acme.edu.network;

public enum ServerKeyWords {
    CLOSE("close"),
    EXIT("exit"),
    FLUSH("flush"),
    LOG("log");

    private String title;

    ServerKeyWords(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
