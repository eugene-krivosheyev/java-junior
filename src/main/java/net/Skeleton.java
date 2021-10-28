package net;

import message.Message;

import java.io.IOException;

public class Skeleton {

    private Acceptor acceptor = new Acceptor();

    public Message receive() {
        try {
            return (Message)acceptor.accept();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
