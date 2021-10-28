package demo.net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try(
                final Socket socket = new Socket("127.0.0.1", 9999);
                final DataInputStream input = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
                final DataOutputStream out = new DataOutputStream(
                        new BufferedOutputStream(socket.getOutputStream()))
        ) {

            out.writeUTF("HW!");
            out.flush();
            final String read = input.readUTF();
            System.out.println(">>>>> " + read);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
