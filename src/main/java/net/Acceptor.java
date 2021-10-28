package net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Acceptor {
    public Object accept() {
        try (
                final ServerSocket serversocket = new ServerSocket(9999);
                final Socket connection = serversocket.accept();
                final ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(connection.getInputStream()));
        ) {
            Object object = input.readObject();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
