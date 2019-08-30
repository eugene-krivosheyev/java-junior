package com.acme.edu.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class Client implements ConnectionListener {
    private static final Logger log = LoggerFactory.getLogger(Connection.class);

    private static final String ip = "localhost";
    private static final int port = 8100;
    private Connection connection;

    public Client() {
        Scanner scan = new Scanner(System.in);
        try {
            String msg = "";
            connection = new Connection(this, ip, port);
            while(!msg.equals("exit")) {
                msg = scan.nextLine();
                connection.sendMessage(msg);
            }
        }catch (IOException ex) {
            log.info("Ошибка создания соединенич: " + ex);
        }
    }

    @Override
    public synchronized void onConnectionReady(Connection connection) {
        log.info("Соединение открыто");
    }

    @Override
    public synchronized void onReceiveString(Connection connection, String message) {
        log.info("Пришло сообщение: " + message);
    }

    @Override
    public synchronized void onDisconnect(Connection connection) {
        log.info("Соединение закрыто");
    }

    @Override
    public synchronized void onException(Connection connection, Exception ex) {
        log.info("Ошибка создания соединенич: " + ex);
    }
}