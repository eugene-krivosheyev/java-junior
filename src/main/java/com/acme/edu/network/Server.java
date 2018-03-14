package com.acme.edu.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket portListener = new ServerSocket(6666)) {
//            portListener.setSoTimeout(1_000);
            while(true) { //Session loop

                try (Socket clientSession = portListener.accept();
                    InputStream inputStream = clientSession.getInputStream();
                     OutputStream outputStream = clientSession.getOutputStream();) {

                    while (true) { //request loop
                            inputStream.read();
                            //business-logic
                            outputStream.write(0);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
