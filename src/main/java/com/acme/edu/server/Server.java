package com.acme.edu.server;

import com.acme.edu.Logger;
import com.acme.edu.exceptions.LogOperationException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8080;
    public static void main(String[] args) {
        try(final ServerSocket connectionListener = new ServerSocket(PORT)) {
            final Socket socket = connectionListener.accept();
            try (final PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    socket.getOutputStream())));
                 final DataInputStream in =
                         new DataInputStream(
                                 new BufferedInputStream(
                                         socket.getInputStream()))) {
                final Object readLine = in.readUTF();
                System.out.println("debug: " + readLine);
                if(readLine.equals("close")){
                    Logger.close();
                }else{
                    Logger.log(readLine); // todo add other types
                }
                out.println("OK");
                out.flush();
            } catch (LogOperationException | IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
