package com.acme.edu;

import com.acme.edu.commands.ByteCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.IntCommand;
import com.acme.edu.commands.StringCommand;
import com.acme.edu.savers.Saver;
import com.acme.edu.savers.SimpleFileSaver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kate-c on 30/08/2019.
 */
public class LoggerServer {

    private static Saver saver = new SimpleFileSaver();

    public static void main(String[] args) {
        try (final ServerSocket connectionListener = new ServerSocket(666)) {
            while(true) {
                final Socket socket = connectionListener.accept();
                Session clientSession = new Session(socket, new LoggerController(saver));
                clientSession.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
