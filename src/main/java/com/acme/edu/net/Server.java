package com.acme.edu.net;

import com.acme.edu.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket portListener = new ServerSocket(6666)) {
            try (Socket clientConnection = portListener.accept();
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(
                                    new BufferedOutputStream(
                                            clientConnection.getOutputStream())));
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    new BufferedInputStream(
                                            clientConnection.getInputStream())))
            ) {
                String line;
                CommandMapper commandMapper = new CommandMapper();
                int loggerResult = 200;
                while ((line = in.readLine()) != null) {
                    loggerResult = commandMapper.mapAndExecute(line);
                }
                System.out.println(String.valueOf(loggerResult));
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
