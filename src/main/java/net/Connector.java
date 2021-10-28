package net;

import message.Message;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Connector {

    private ObjectOutputStream output;

    private void connect() {
        try {
            Socket socket = new Socket(InetAddress.getLoopbackAddress(), 9999);
            output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(Message message) throws IOException {
        int count = 0;
        int maxTries = 10;
        while (true) {
            try {
                output.writeObject(message);
                output.flush();
                return;
            } catch (NullPointerException | IOException e) {
                connect();
                if (++count == maxTries) throw e;
            }
        }
    }

}
