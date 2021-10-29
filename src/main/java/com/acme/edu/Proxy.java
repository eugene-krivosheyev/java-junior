package com.acme.edu;

import com.acme.edu.messages.Message;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Proxy {
    public static void main(String[] args) {
//        public void ProxyRequest(String message){
            try(
                    final Socket socket = new Socket("127.0.0.1", 9999);
                    final DataOutputStream out = new DataOutputStream(
                            new BufferedOutputStream(socket.getOutputStream()))
            ) {

//                out.writeUTF(message);
                out.writeUTF("1");
                out.flush();
                out.writeUTF("2");
                out.flush();
                out.writeUTF("flush");
                out.flush();
                out.writeUTF("end session");
                out.flush();



            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

