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
    private Thread thread;

    public Server(ConnectionListener manager, int port) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { if (!thread.isInterrupted()) thread.interrupt(); }));
        System.out.println("Сервер запускается...");
        this.connectionListener = manager;
        this.thread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                while (!thread.isInterrupted()) {
                    Socket socket = serverSocket.accept();
                    Connection connection = new Connection(connectionListener, socket);
                    connection.init();
                    log.info("Новый клиент: " + socket.toString());
                }
            } catch (IOException ex) {
                log.error("Ошибка создания нового соединения!");
                throw new ConnectionException(ex);
            } finally {
                destroy();
            }
        });
        thread.start();
    }

    public void destroy()  { if (serverSocket != null && !serverSocket.isClosed()) close(); }

    private void close() {
        try {
            log.info("Сервер закрывается...");
            serverSocket.close();
        } catch (IOException e) {
            log.error("Невозможно корректно завершить работу сервера!!!");
            throw new RuntimeException(e);
        }
    }
}