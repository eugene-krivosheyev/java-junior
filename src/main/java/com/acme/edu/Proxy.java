package com.acme.edu;

import com.acme.edu.messages.Message;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Proxy {
        public void ProxyRequest(String message){
            try(
                    final Socket socket = new Socket("127.0.0.1", 9999);
                    final DataOutputStream out = new DataOutputStream(
                            new BufferedOutputStream(socket.getOutputStream()))
            ) {

                out.writeUTF(message);
                out.flush();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

