package com.acme.edu.net;

public interface ConnectionListener {
    void onConnectionReady(Connection connection);
    void onReceiveString(Connection connection, String message);
    void onDisconnect(Connection connection);
}
