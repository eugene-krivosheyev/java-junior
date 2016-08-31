package networkin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkingDemo {
    public static void main(String[] args) {

    }
}


class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1111)) {

            Socket client = serverSocket.accept();


            try (
                DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                        client.getInputStream()
                    )
                )
            ) {
                System.out.println(in.readChar());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client {
    public static void main(String[] args) throws IOException {
        try (
            DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                    new Socket("localhost", 1111).getOutputStream()
                )
            )
        ) {
            out.writeChar('q');
        }
    }
}
