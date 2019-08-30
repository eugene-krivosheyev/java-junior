package com.acme.edu.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (
                final Socket socket = new Socket(HOST, PORT);
                final DataOutputStream out =
                        new DataOutputStream(
                                new BufferedOutputStream(socket.getOutputStream()));
                final BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(socket.getInputStream())))
        ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the data for logs or type \"close\" to exit");
            while (sc.hasNextLine()) {
                String message = sc.nextLine();
                out.writeUTF(message);
                out.flush();
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
