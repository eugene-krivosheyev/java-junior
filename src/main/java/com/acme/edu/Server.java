package com.acme.edu;

import commands.Command;
import commands.IntCommand;
import commands.StringCommand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {

            LoggerController logger = new LoggerController(new FileSaver(4, 1));
            RequestParser parser = new RequestParser();

            while (true) {
                try (final ServerSocket connectionListener = new ServerSocket(666)) {

                    // todo tests
                    // todo class acceptor
                    final Socket socket = connectionListener.accept();

                    try (final PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(
                                    new BufferedOutputStream(
                                            socket.getOutputStream())));
                         final BufferedReader in = new BufferedReader(
                                 new InputStreamReader(
                                         new BufferedInputStream(
                                                 socket.getInputStream())))) {

                        while (true) {
                            final String rawRequest = in.readLine();


                            System.out.println("debug: " + rawRequest);

                            // todo class parser
                            Request request = parser.parse(rawRequest);


                            if (request.type.equals("flush")) {
                                logger.flush();
                            } else {
                                Command command = defineCommandType(request);
                                logger.log(command);
                            }
                            //out.println(">> " + readLine);
                            //out.flush();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static Command defineCommandType(Request request) {
        if (request.type.equals("string")) {
            return new StringCommand(request.value);
        } else if (request.type.equals("int")) {
            return new IntCommand(Integer.parseInt(request.value));
        } else {
            System.out.println(("ERROR: Unsupported message type: " + request.type + "!"));
            throw new IllegalStateException();
        }
    }

}