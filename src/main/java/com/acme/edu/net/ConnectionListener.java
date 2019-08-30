package com.acme.edu.net;

public interface ConnectionListener {
    void onReceiveMessage(Connection connection, String message);
}
