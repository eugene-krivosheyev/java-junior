package com.acme.edu;

import com.acme.edu.messages.IntMessage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Skeleton {
    private static Printer printer = new Printer();
    private static Controller controller = new Controller(printer);

    public static void main(String[] args) {
        try (final ServerSocket listener = new ServerSocket(9999);
             final Socket connection = listener.accept();
             final DataInputStream input = new DataInputStream(
                     new BufferedInputStream(connection.getInputStream()));
             //     final DataOutputStream out = new DataOutputStream(
             //       new BufferedOutputStream(connection.getOutputStream()));
        ) {
            String read = "";
            while (!read.equals("end session")) {
//            while (input.available() > 0) {
                read = input.readUTF();

                if (read.equals("flush")) {
                    controller.flush();
                } else if (!read.equals("end session")) {
                    controller.log(new IntMessage(Integer.parseInt(read)));
                }

                //  }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
