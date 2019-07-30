package com.acme.edu.network;

public class ProtocolHandler {
    public static ServerKeyWords acceptMessage(String message){
        if(message.equals(ServerKeyWords.CLOSE.getTitle())) {
            return ServerKeyWords.CLOSE;
        }
        if(message.equals(ServerKeyWords.EXIT.getTitle())) {
            return ServerKeyWords.EXIT;
        }
        if(message.equals(ServerKeyWords.FLUSH.getTitle())) {
            return ServerKeyWords.FLUSH;
        }
        return ServerKeyWords.LOG;
    }
}
