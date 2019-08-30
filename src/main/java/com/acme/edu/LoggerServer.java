package com.acme.edu;

import com.acme.edu.commands.ByteCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.IntCommand;
import com.acme.edu.commands.StringCommand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kate-c on 30/08/2019.
 */
public class LoggerServer {
    private static LoggerController loggerController = new LoggerController();

    public static void main(String[] args) {
        try(final ServerSocket connectionListener = new ServerSocket(666)) {
            final Socket socket = connectionListener.accept();

            processOneClient(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processOneClient(Socket socket) {
        try (final PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                socket.getOutputStream())));
             final BufferedReader in = new BufferedReader(
                     new InputStreamReader(
                             new BufferedInputStream(
                                     socket.getInputStream())))) {

            String request;
            while ((request = in.readLine()) != null) {
                try {
                    System.out.println("debug: " + request);
                    processRequest(request);
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println(e.getMessage());
                    out.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processRequest(String request) {
        int spaceIndex = request.indexOf(" ");
        String type = request.substring(0, spaceIndex);
        String message = request.substring(spaceIndex + 1, request.length());

        Command command = null;
        switch (type) {
            case "IntCommand": {
                int body = Integer.parseInt(message);
                command = new IntCommand(body);
                break;
            }
            case "ByteCommand": {
                byte body = Byte.parseByte(message);
                command = new ByteCommand(body);
                break;
            }
            case "StringCommand": {
                command = new StringCommand(message);
                break;
            }
            case "Flush": {
                loggerController.flush();
                break;
            }
            default:
                throw new UnsupportedOperationException("Unsupported command type: " + type);
        }

        if (command != null) {
            loggerController.log(command);
        }
    }
}
