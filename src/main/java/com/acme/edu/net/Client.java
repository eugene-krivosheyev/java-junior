package com.acme.edu.net;

import com.acme.edu.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Client implements ConnectionListener {
    private static final Logger log = LoggerFactory.getLogger(Connection.class);

    private static final String ip = "localhost";
    private static final int port = 8102;
    private Connection connection;

    public Client() {
        try {
            connection = new Connection(this, ip, port);
        } catch (IOException ex) {
            log.info("Ошибка создания соединения: " + ex);
        }
    }

    public void sendCommand(Command command) {
        connection.sendMessage(command.getMessage() + ":" + command.getState().toString());
    }

    @Override
    public synchronized void onConnect(Connection connection) {
        log.info("Соединение открыто");
    }

    @Override
    public synchronized void onReceiveMessage(Connection connection, String message) {
        log.info("Пришло сообщение: " + message);
    }

    @Override
    public synchronized void onDisconnect(Connection connection) {
        log.info("Соединение закрыто");
    }

}