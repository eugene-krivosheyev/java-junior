package demo.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(final ServerSocket listener = new ServerSocket(9999);
            final Socket connection = listener.accept();
            final DataInputStream input = new DataInputStream(
                    new BufferedInputStream(connection.getInputStream()));
            final DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(connection.getOutputStream()));
        ) {

            final String read = input.readUTF();
            out.writeUTF(read + " <<<<<<<<");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
