package net;

import message.Message;

public class Skeleton {

    private Acceptor acceptor = new Acceptor();

    public Message receive() {
        return (Message)acceptor.accept();
    }
}
