package demo.net;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
            final Socket connection = new Socket("localhost", 10_000);
            final DataInputStream input = new DataInputStream(new BufferedInputStream(connection.getInputStream()));
            final DataOutputStream output = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()))
        ) {

            output.writeUTF("hello!"); // protocol
            output.writeUTF("hello!"); // protocol
            output.writeUTF("hello!"); // protocol
            output.writeUTF("hello!"); // protocol
            output.writeUTF("hello!"); // protocol
            output.writeUTF("hello!"); // protocol
            output.flush();
            //.....
            System.out.println(input.readUTF());

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
