package com.acme.edu.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Thread.currentThread;

class Connector {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    Connector(Socket socket, BufferedReader in, PrintWriter out) {
        this.socket = socket;
        this.in = in;
        this.out = out;

        Runtime.getRuntime().addShutdownHook(new Thread(this::disconnect));
    }

    String readLine() throws IOException {
        return in.readLine();
    }

    void println(String s) {
        out.println(s);
    }

    private void disconnect() {
        try {
            out.close();
            in.close();
            socket.close();

            System.out.println("Successfully closed resources for client " + currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
