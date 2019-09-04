package com.acme.edu.chat;

import java.io.IOException;
import java.util.Scanner;

public class Client implements ConnectionListener {

    private static final String ip = "localhost";
    private static final int port = 8100;
    private Connection connection;
    private static final String name = "";

    Client() {
        Scanner scan = new Scanner(System.in);
        try {
            String msg = "";
            connection = new Connection(this, ip, port);
            while(!msg.equals("exit")) {
                msg = scan.nextLine();
                connection.sendMessage(name+": "+msg);
            }
            connection.disconnect();
        }catch (IOException ex) {
            printMessage("Connection exception: "+ex);
        }
    }

    @Override
    public synchronized void onConnectionReady(Connection connection) {
        printMessage("Connection opened");
    }

    @Override
    public synchronized void onReceiveString(Connection connection, String message) {
        printMessage(message);
    }

    @Override
    public synchronized void onDisconnect(Connection connection) {
        printMessage("Connection closed");
    }

    @Override
    public synchronized void onException(Connection connection, Exception ex) {
        printMessage("Connection exception: "+ex);
    }

    private synchronized void printMessage(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        new Client();
    }

}