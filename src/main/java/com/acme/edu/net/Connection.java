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
        this(listener, new Socket(ip, port));
    }

    public Connection(ConnectionListener listener, Socket socket) throws IOException {
        this.listener = listener;
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    public void init() {
        thread = new Thread((() -> {
            try {
                while (!thread.isInterrupted() && !socket.isClosed()) {
                    String msg = in.readLine();
                    listener.onReceiveMessage(Connection.this, msg);
                }
            } catch (IOException ex) {
                log.error("Ошибка чтения: " + ex);
                throw new ConnectionException(ex);
            } finally {
                disconnect();
            }
        }));
        thread.start();
    }

    public synchronized void sendMessage(String msg) {
        try {
            out.write(msg + "\r\n");
            out.flush();
        } catch (IOException e) {
            log.error("Ошибка отправки сообщения: " + e);
            throw new ConnectionException(e);
        }
    }

    public synchronized void disconnect()  {
        try {
            if (socket!=null && !socket.isClosed()) {
                log.info("Закрываем сокет: " + socket.toString());
                socket.close();
            }
            if (!thread.isInterrupted())
                thread.interrupt();
        } catch (IOException e) {
            log.error("Сокет не может быть закрыт: " + e);
            throw new ConnectionException(e);
        }
    }

    @Override
    public String toString() { return "Connection: " + socket.getInetAddress() + ": " + socket.getPort(); }

}