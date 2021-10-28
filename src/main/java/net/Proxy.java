package net;

import message.Message;

public class Proxy {
    private final Connector connector;

    public Proxy(Connector connector) {
        this.connector = connector;
    }

    public void send(Message message) {
        connector.send(message);
    }
}
