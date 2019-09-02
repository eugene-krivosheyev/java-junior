package com.acme.edu.mylogger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SuperServer {
    private static LoggerController loggerController = new LoggerController(
            new SuperCurrentAccumulator(), new SuperFileSaver(new File("logger2.txt")));

    public static void main(String[] args) {

        while (true) {
            try (final ServerSocket connectionListener = new ServerSocket(666)) {
                final Socket socket = connectionListener.accept();

                try (final PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        socket.getOutputStream())));
                     final BufferedReader in = new BufferedReader(
                             new InputStreamReader(
                                     new BufferedInputStream(
                                             socket.getInputStream())))) {

                    final String readLine = in.readLine();
                    System.out.println("debug: " + readLine);

                    getCommand(readLine);
                    out.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        public static void getCommand(String readLine) {
            String[] command = readLine.split(" ");
            if ("String".equals(command[0])) {
                System.out.println(command[1]);
                loggerController.log(new StringCommand(command[1]));
            } else if ("Integer".equals(command[0])) {
                System.out.println("Integer");
                loggerController.log(new IntCommand(Integer.parseInt(command[1])));
            } else if ("Byte".equals(command[0])) {
                loggerController.log(new ByteCommand(Byte.parseByte(command[1])));
            } else if ("Flush".equals(command[0])) {
                loggerController.flush();
            }
        }

}
