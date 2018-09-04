package com.acme.edu.clientside;

import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.*;

import java.io.*;
import java.net.Socket;

public class LoggerProxy implements Closeable{
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public LoggerProxy(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                socket.getOutputStream())));
        in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                socket.getInputStream())));
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
        socket = null;
    }

    private int send(String message) {
        if (socket == null) {
            return 1;
        }
        out.println(message);
        out.flush();
        return 0;
    }

    public int flush() {
        return send("<flush>");
    }

    public int log(int message) {
        return send("<int>" + message);
    }

    public int log(int[] message) {
        return 0;//controller.log(new IntArrayMessage(message));
    }

    public int log(int[][] message) {
        return 0;//controller.log(new IntMatrixMessage(message));
    }

    public int log(byte message) {
        return send("<byte>" + message);
    }

    public int log(char message) {
        return send("<char>" + message);
    }

    public int log(String message) {
        return send("<string>" + message);
    }

    public int log(boolean message) {
        return send("<boolean>" + message);
    }

    public int log(Object message) {
        return 0;//controller.log(new ReferenceMessage(message));
    }

    public int setDecorator(MessageType type, Decorator newDecorator) {
        return 0;//controller.update(type, newDecorator);
    }
}
