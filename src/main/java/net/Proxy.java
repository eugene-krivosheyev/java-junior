package net;

import message.Message;

import java.io.IOException;

public class Proxy {
    private final Connector connector;

    public Proxy(Connector connector) {
        this.connector = connector;
    }

    public void send(Message message) {
        try {
            connector.send(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
