package com.acme.edu.network;

import com.acme.edu.Logger;
import com.acme.edu.command.IntCommand;
import com.acme.edu.saver.FileLoggerSaver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoggerServer {
    private static boolean isWork = true;
    private static boolean workWithClient = true;


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (isWork) {
                FileLoggerSaver fls = new FileLoggerSaver("journal.txt");
                Logger.setSaver(fls);
                Socket client = serverSocket.accept();
                try (final BufferedWriter out =
                             new BufferedWriter(
                                     new OutputStreamWriter(
                                             new BufferedOutputStream(
                                                     client.getOutputStream())));
                     final BufferedReader in =
                             new BufferedReader(
                                     new InputStreamReader(
                                             new BufferedInputStream(
                                                     client.getInputStream())))) {
                    workWithClient = true;
                    while(workWithClient) {
                        String message = in.readLine();
                        System.out.println(message);
                        out.write("fine");
                        out.newLine();
                        out.flush();
                        String[] commandParse = message.split(",");
                        parseMessage(commandParse);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                client.close();
                Logger.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void parseMessage(String[] message) throws Exception {
        if (message.length < 1) {
            return;
        }
        if (message[0].equals("flush")) {
            Logger.flush();
            return;
        }
        if (message[0].equals("close")) {
            workWithClient = false;
            Logger.close();
            return;
        }
        if(message[0].equals("exit")){
            isWork = false;
            workWithClient = false;
            Logger.close();
            return;
        }
        if (message.length > 1) {
            logMessage(message);
            return;
        }
    }

    private static void logMessage(String[] message) throws Exception {
        if (message[0].equals("int")) {
            Logger.log(Integer.parseInt(message[1]));
            return;
        }
        if (message[0].equals("byte")) {
            Logger.log(Byte.parseByte(message[1]));
            return;
        }
        if (message[0].equals("string")) {
            Logger.log(message[1]);
            return;
        }
        if (message[0].equals("boolean")) {
            Logger.log(Boolean.parseBoolean(message[1]));
            return;
        }
        //TODO:another parse of char
        if (message[0].equals("char")) {
            Logger.log(message[1].toCharArray()[0]);
            return;
        }
    }
}
