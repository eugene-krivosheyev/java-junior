package demo.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (final ServerSocket listener = new ServerSocket(10_000)) {

            try (
//                listener.setSoTimeout();
                final Socket connection = listener.accept();
                final DataInputStream input = new DataInputStream(new BufferedInputStream(connection.getInputStream()));
                final DataOutputStream output = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()))
            ) {

                while (true) {
                    final String read = input.readUTF();
                    output.writeUTF(">>>>>>> " + read);
                    output.flush();
                }

            } catch (IOException e) {
                e.printStackTrace(System.err);
            }

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
