package com.acme.edu.net;

public interface ConnectionListener {
    void onConnect(Connection connection);
    void onReceiveMessage(Connection connection, String message);
    void onDisconnect(Connection connection);
}
