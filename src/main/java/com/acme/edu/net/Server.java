package com.acme.edu.net;

import com.acme.edu.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.currentThread;

public class Server {
    static final int PORT = 2019;

    public static void main(String[] args) {
        try (final ServerSocket connectionListener = new ServerSocket(PORT)) {
            while (!currentThread().isInterrupted()) {
                final Socket socket = connectionListener.accept();

                try {
                    final BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    new BufferedInputStream(socket.getInputStream())));
                    final PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(
                                    new BufferedOutputStream(socket.getOutputStream())));

                    Thread t = new ClientSession(new Connector(socket, in, out));
                    t.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientSession extends Thread {
    private final Connector connector;

    ClientSession(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void run() {
        try {
            while (!currentThread().isInterrupted()) {
                String message = connector.readLine();
                if (message != null) {
                    processMessage(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processMessage(String message) {
        String messageType = message;
        String messageBody = "";
        int spaceIndex = message.indexOf(' ');

        if (spaceIndex != -1) {
            messageType = message.substring(0, spaceIndex);
            messageBody = message.substring(spaceIndex + 1);
        }

        switch (MessageType.valueOf(messageType)) {
            case FLUSH:
                Logger.flush();
                break;
            case BYTE:
                Logger.log(Byte.parseByte(messageBody));
                break;
            case INT:
                Logger.log(Integer.parseInt(messageBody));
                break;
            case CHAR:
                Logger.log(messageBody.charAt(0));
                break;
            case STRING:
                Logger.log(messageBody);
                break;
            default:
                throw new RuntimeException(String.format("Type %s is not supported on server-side yet", messageType));
        }
    }
}

