package demo.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (final ServerSocket connectionPortListener = new ServerSocket(10_000);
            final Socket clientConnection = connectionPortListener.accept();
            final DataInputStream input = new DataInputStream(
                    new BufferedInputStream(
                            clientConnection.getInputStream()));
            final DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(
                            clientConnection.getOutputStream()))) {

                final String readLine = input.readUTF();
                out.writeUTF("!!! " + readLine);
                out.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
