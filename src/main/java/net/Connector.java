package net;

import message.Message;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Connector {
    public void send(Message message) {
        try (
                //final Socket socket = new Socket(InetAddress.getByName("Daedroth"), 9999);
                final Socket socket = new Socket(InetAddress.getLoopbackAddress(), 9999);
                final ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        ) {
            output.writeObject(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
