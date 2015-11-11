package com.acme.edu.logger;

import com.acme.edu.printer.PrinterException;
import com.acme.edu.printer.RemotePrinter;
import com.acme.edu.server.Server;

import java.io.IOException;

/**
 * Created by Павел on 11.11.2015.
 */
public class Test {
    public static void main(String[] args) throws PrinterException, IOException, LogException {
        Logger logger = new Logger(new Factory(), new RemotePrinter("127.0.0.1",6666));
        Server server = new Server(6666,"UTF-8");
        Thread thread = new Thread(server);
      //  thread.start();

        for (int i = 0; i < 500; i++) {
            logger.log("ERROReerw");
            logger.log("ERReerw");
            logger.flush();
        }
    }
}
