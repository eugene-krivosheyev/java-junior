package com.acme.networkingdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class EchoServer {
    public static void main(String[] args) {
        serverLoop(EchoServer::clientLoop);
    }

    private static void serverLoop(Consumer<Socket> toDo) {
        try (ServerSocket listener
                     = new ServerSocket(9999)) {

            while (true) {
                Socket client = listener.accept();
                new Thread(() -> toDo.accept(client)).start();
            }

        } catch (IOException e) {

        }
    }

    private static void clientLoop(Socket client) {
        try (
                OutputStream outputStream = client.getOutputStream();
                InputStream inputStream = client.getInputStream();
        ) {

            while (true) {
                outputStream.write(
                        inputStream.read()
                );
            }

        } catch (IOException e) {

        }
    }
}
