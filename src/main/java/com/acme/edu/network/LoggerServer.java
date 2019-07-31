package com.acme.edu.network;

import com.acme.edu.Logger;
import com.acme.edu.saver.FileLoggerSaver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoggerServer {
    private static volatile boolean isWork = true;
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) throws IOException {
        try  {
            serverSocket = new ServerSocket(8080);
            ServerThread serverThread = new ServerThread(serverSocket);
            serverThread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
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

    private static class ServerThread extends Thread {
        private ServerSocket serverSocket;

        public ServerThread(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            FileLoggerSaver fls = null;
            try {
                fls = new FileLoggerSaver("journal.txt");
                Logger.setSaver(fls);
                while (isWork) {
                    Socket client = serverSocket.accept();
                    new ClientThread(client).start();
                }
                Logger.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Logger.setSaver(fls);
        }
    }

    private static class ClientThread extends Thread {
        private Socket client;
        private BufferedWriter out;
        private BufferedReader in;
        private boolean workWithClient;

        public ClientThread(Socket client) throws IOException {
            this.client = client;
            this.out = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    client.getOutputStream())));
            this.in = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    client.getInputStream())));
        }

        @Override
        public void run() {
            try {
                workWithClient = true;
                while (workWithClient) {
                    String message = in.readLine();
                    System.out.println(message);
                    out.write("fine");
                    out.newLine();
                    out.flush();
                    ServerKeyWords keyWord = ProtocolHandler.acceptMessage(message);
                    if (!keyWord.equals(ServerKeyWords.LOG)) {
                        manageServer(keyWord);
                    } else {
                        String[] commandParse = message.split(",");
                        logMessage(commandParse);
                    }
                }
                client.close();
            } catch (IOException ex) {
                System.out.println(Thread.currentThread().getName()+"Exception");
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void manageServer(ServerKeyWords keyWords) throws IOException {
            if (keyWords.equals(ServerKeyWords.FLUSH)) {
                Logger.flush();
                return;
            }
            if (keyWords.equals(ServerKeyWords.CLOSE)) {
                Logger.flush();
                workWithClient = false;
                return;
            }
            if (keyWords.equals(ServerKeyWords.EXIT)) {
                Logger.flush();
                isWork = false;
                workWithClient = false;
                serverSocket.close();
                return;
            }
        }
    }
}


