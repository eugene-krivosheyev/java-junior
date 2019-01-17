package demo.iodemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP/IP: Socket
 * UDP: Datagram
 */
public class DistributedDemo {

}

//HttpClient: blocking IO + HTTP parsing
class Client {
    public static void main(String[] args) {
        try (Socket connection =
                    new Socket("localhost", 6666)) {

            //Google Protobuf, Apache Thrift: binary
            //xml | json over HTTP
            try (PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    connection.getOutputStream())));

                 BufferedReader in = new BufferedReader(new InputStreamReader(
                         new BufferedInputStream(
                                 connection.getInputStream())));
            ) {

                out.println("hello");
                out.flush();
                System.out.println("debug: flushed");
                System.out.println(">>> " + in.readLine());

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//Netty | Apache MINA: NIO2
//HTTP container: Tomcat | Jetty | Apache MINA HTTP
class Server {
    public static void main(String[] args) {
        try (ServerSocket portListener = new ServerSocket(6666)) {
//            portListener.setSoTimeout(10_000);
            Socket clientConnection = portListener.accept();
            System.out.println("debug: accepted");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    new BufferedInputStream(
                            clientConnection.getInputStream())));

                PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                clientConnection.getOutputStream())));
            ) {

                String readLine = in.readLine();
                System.out.println("debug: read");

                out.println("+++ " + readLine);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
