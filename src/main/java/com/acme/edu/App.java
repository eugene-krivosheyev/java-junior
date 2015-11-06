package com.acme.edu;

import java.io.*;
import java.net.Socket;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try(
            Socket socket = new Socket("127.0.0.1", 6666);
        ) {

            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            os.writeUTF("text");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}