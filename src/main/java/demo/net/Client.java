package demo.net;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (final Socket connection = new Socket("127.0.0.1", 10_000);
             final DataInputStream input = new DataInputStream(
                     new BufferedInputStream(
                             connection.getInputStream()));
             final DataOutputStream out = new DataOutputStream(
                     new BufferedOutputStream(
                             connection.getOutputStream()));
        ) {

            System.out.println(connection.getLocalPort());
            out.writeUTF("HW!!!");
            out.flush();
            System.out.println(">> " + input.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
