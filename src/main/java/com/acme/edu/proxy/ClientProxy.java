package com.acme.edu.proxy;

import java.io.*;
import java.net.Socket;

public class ClientProxy {
    public static void main(String[] args) {
        try (
                final Socket socket = new Socket("127.0.0.1", 9999);
                final DataInputStream input = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
                final DataOutputStream out = new DataOutputStream(
                        new BufferedOutputStream(socket.getOutputStream()))
        ) {
            out.writeInt(1);
            out.writeInt(0);
            out.writeInt(-1);
            out.flush();

            final String read = input.readUTF();
            System.out.println("\n>>>>> " + read);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
