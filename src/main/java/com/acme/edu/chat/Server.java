package com.acme.edu.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements ConnectionListener {

    private final ArrayList<Connection> connections = new ArrayList<>();

    private Server() {
        System.out.println("Server running...");
        try (ServerSocket serverSocket = new ServerSocket(8100)) {
            while (true) {
                try {
                    connections.add(new Connection(this, serverSocket.accept()));
                } catch (IOException e) {
                    System.out.println("Connection exception: " + e);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        new Server();
    }

    @Override
    public synchronized void onConnectionReady(Connection connection) {
        connections.add(connection);
        sendToAllConnections("New user connected: " + connection);
    }

    @Override
    public synchronized void onReceiveString(Connection connection, String message) {
        sendToAllConnections(message);
    }

    @Override
    public synchronized void onDisconnect(Connection connection) {
        connections.remove(connection);
        sendToAllConnections("User disconnected: " + connection);
    }

    @Override
    public synchronized void onException(Connection connection, Exception ex) {
        System.out.println("Connection exception: " + ex);
    }

    private void sendToAllConnections(String msg) {
// System.out.println(msg);
        for (Connection c : connections)
            c.sendMessage(msg);
    }

}
