package com.acme.edu.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Connection {
    private static final Logger log = LoggerFactory.getLogger(Connection.class);

    private Thread thread;
    private ConnectionListener listener;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public Connection(ConnectionListener listener, String ip, int port) throws IOException {
        try {
            this.socket = new Socket(ip, port);
        } catch (IOException e) { throw new RuntimeException(e); }
        init(listener, socket);
    }

    public Connection(ConnectionListener listener, Socket socket) throws IOException {
        this.socket = socket;
        init(listener, socket);
    }

    private void init(ConnectionListener listener, Socket socket) throws IOException{
        this.listener = listener;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        thread = new Thread((() -> {
            try {
                listener.onConnect(Connection.this);
                while (!thread.isInterrupted()) {
                    String msg = in.readLine();
                    listener.onReceiveMessage(Connection.this, msg);
                }
            } catch (IOException ex) {
                log.error("Ошибка создания соединения: " + ex);
            } finally {
                listener.onDisconnect(Connection.this);
            }
        }));
        thread.start();
    }

    public synchronized void sendMessage(String msg) {
        try {
            out.write(msg + "\r\n");
            out.flush();
        } catch (IOException e) {
            log.error("Ошибка создания соединения: " + e);
        }
    }

    public synchronized void disconnect() {
        thread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            log.error("Ошибка создания соединения: " + e);
        }
    }

    public boolean isClosed() {
        return socket.isClosed();
    }

    @Override
    public String toString() { return "Connection: " + socket.getInetAddress() + ": " + socket.getPort(); }

}