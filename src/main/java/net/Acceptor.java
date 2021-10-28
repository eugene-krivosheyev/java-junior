package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Acceptor {

    private ObjectInputStream input;
    private ServerSocket serversocket;

    private void connect() {
        try {
            if (serversocket != null) serversocket.close();
            serversocket = new ServerSocket(9999);
            final Socket connection = serversocket.accept();
            input = new ObjectInputStream(new BufferedInputStream(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object accept() throws IOException {
        int count = 0;
        int maxTries = 10;
        while (true) {
            try {
                return input.readObject();
            } catch (NullPointerException | IOException e) {
                connect();
                if (++count == maxTries) {
                    throw e;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
