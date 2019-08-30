package com.acme.edu;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kate-c on 30/08/2019.
 */
public class LoggerClient {
    public static void main(String[] args) {
        try (
                final Socket socket = new Socket("localhost", 666);
                final PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(socket.getOutputStream())));
                final BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(socket.getInputStream())));
                //final Scanner scanner = new Scanner(System.in);
                )
        {
//            String message = "";
//            while (!message.equals("exit")) {
//                message = scanner.nextLine();
//                out.println(message);
//                out.flush();
//            }
            out.println("IntCommand 2");
            out.println("IntCommand 3");
            out.println("IntCommand 8");
            out.println("ByteCommand 8");
            out.println("StringCommand eto message");
            out.println("Flush Sooqa!");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
