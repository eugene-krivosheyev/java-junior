package com.acme.networkingdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket listener
                     = new ServerSocket(9999)) {

            while (true) {

                Socket client = listener.accept();
                new Thread(() -> ((Consumer<Socket>) client1 -> {
                    try (
                            OutputStream outputStream = client1.getOutputStream();
                            InputStream inputStream = client1.getInputStream();
                    ) {

                        while (true) {
                            outputStream.write(
                                    inputStream.read()
                            );
                        }

                    } catch (IOException e) {

                    }
                }).accept(client)).start();
            }

        } catch (IOException e) {

        }
    }

}
