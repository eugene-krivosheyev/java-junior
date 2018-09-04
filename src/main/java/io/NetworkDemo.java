package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkDemo {
}

/**
 * Apache MINA, Netty -> Jetty
 * Apache Tomcat
 *
 */
class Client {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("127.0.0.1", 6666);
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    socket.getOutputStream())));
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    socket.getInputStream())));
        ) {

            out.println("GET / HTTP/1.0");
            out.println();
            out.flush();

            String line = null;
//            while ((
            line = in.readLine();
//            )!= null) {
                System.out.println("клиент получил: " + line);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Server {
    public static void main(String[] args) {
        try (ServerSocket portListener = new ServerSocket(6666)) {

            try (   Socket clientConnection = portListener.accept();
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(
                                    new BufferedOutputStream(
                                            clientConnection.getOutputStream())));
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    new BufferedInputStream(
                                            clientConnection.getInputStream())));
            ) {


                String line = null;
//                while ((
                        line = in.readLine();
//                ) != null) {
                    System.out.println("сервер: " + line);
//                }


                out.println("200 Ok");
                out.println();
                out.flush();



            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}