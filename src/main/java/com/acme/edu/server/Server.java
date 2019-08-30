package com.acme.edu.server;

import com.acme.edu.Logger;
import com.acme.edu.exceptions.LogOperationException;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Server {
    private static final int PORT = 8080;
    public static void main(String[] args) {
        try(final ServerSocket connectionListener = new ServerSocket(PORT)) {
            final Socket socket = connectionListener.accept();
            try (final PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    socket.getOutputStream())));
                 final DataInputStream in =
                         new DataInputStream(
                                 new BufferedInputStream(
                                         socket.getInputStream()))) {
                while(true) {
                    final String readLine = in.readUTF();
                    System.out.println("debug: " + readLine);
                    processTypesAndLogCommands(readLine);
                    out.println("OK");
                    out.flush();
                }
            } catch (LogOperationException | IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processTypesAndLogCommands(String readLine) throws LogOperationException {
        String data = readLine.substring(0, readLine.indexOf("_"));
        String type = readLine.substring(readLine.indexOf("_") + 1);
        switch (type) {
            case "int":
                Logger.log(Integer.parseInt(data));
                break;
            case "byte":
                Logger.log(Byte.parseByte(data));
                break;
            case "string":
                Logger.log(data);
                break;
            case "stringVarArgs":
                Logger.log(data
                        .replace("[", "")
                        .replace("]", "")
                        .split(","));
                break;
            case "integerVarArgs":
                Logger.log(Arrays.stream(data
                        .replace("[", "")
                        .replace("]", "")
                        .split(","))
                        .map(Integer::parseInt));
                break;
            case "integerArray4D":
                Logger.log(data); // todo parse Array4D
                break;
            case "integerArray2D":
                break;
            case "integerArray1D":
                Logger.log(Arrays.stream(data
                        .replace("[", "")
                        .replace("]", "")
                        .split(","))
                        .map(Integer::parseInt));
                break;
            case "boolean":
                Logger.log(Boolean.parseBoolean(data));
                break;
            case "object":
                Logger.log(data); //todo parse Object
                break;
            case "char":
                Logger.log(data.charAt(0));
                break;
        }
    }
}
