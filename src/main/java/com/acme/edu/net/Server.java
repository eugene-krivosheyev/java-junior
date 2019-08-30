package com.acme.edu.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    private static final Logger log = LoggerFactory.getLogger(Server.class);
    private ConnectionListener connectionListener;
    private ServerSocket serverSocket;

    public Server(ConnectionListener manager, int port) {
        System.out.println("Сервер запускается...");
        this.connectionListener = manager;
        new Thread(() -> {
            try  {
                serverSocket = new ServerSocket(port);
                Socket socket = serverSocket.accept();
                Connection connection = new Connection(connectionListener, socket);
                while (true) {
                    if (connection.isClosed()) {
                        socket = serverSocket.accept();
                        connection = new Connection(connectionListener, socket);
                    } else Thread.yield();
                }
            } catch (IOException ex) {
                log.error("Ошибка создания нового соединения!");
                throw new RuntimeException(ex);
            }
        }).start();
    }

    public void destroy() { if (serverSocket != null && !serverSocket.isClosed()) close(); }

    private void close() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}