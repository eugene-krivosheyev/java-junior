package com.acme.edu.logger;

import com.acme.edu.server.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Павел on 08.11.2015.
 */
public class Test  {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server(6666);
        Thread thread = new Thread(server);
        thread.start();
        Thread.sleep(2000);
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
