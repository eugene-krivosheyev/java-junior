package com.acme.edu.net;

import java.io.*;
import java.net.Socket;

class ClientProxy {
    private Connector connector;

    ClientProxy(Connector connector) {
        this.connector = connector;
    }

    void log(byte message) {
        connector.println(MessageType.BYTE + " " + message);
    }

    void log(int message) {
        connector.println(MessageType.INT + " " + message);
    }

    void log(char message) {
        connector.println(MessageType.CHAR + " " + message);
    }

    void log(String message) {
        connector.println(MessageType.STRING + " " + message);
    }

    void flush() {
        connector.println(MessageType.FLUSH.name());
    }

    public static void main(String[] args) {
        Connector connector = null;

        try {
            Socket socket = new Socket("localhost", Server.PORT);
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(socket.getOutputStream())));
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(socket.getInputStream())));

            connector = new Connector(socket, in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClientProxy clientProxy = new ClientProxy(connector);
        clientProxy.log(123);
        clientProxy.log(321);
        clientProxy.log((byte) 100);
        clientProxy.flush();
        clientProxy.log((byte) 11);
        clientProxy.log(Byte.MAX_VALUE);
        clientProxy.log((byte) 120);
        clientProxy.log((byte) 1);
        clientProxy.log("Yusuf");
        clientProxy.log("BASHA");
        clientProxy.log("BASHA");
        clientProxy.log("BASHA");
        clientProxy.log("smth");
        clientProxy.log('A');
        clientProxy.log("smth");
        clientProxy.log("smth");
        clientProxy.flush();
    }
}
