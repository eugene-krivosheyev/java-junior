package net;

import com.acme.edu.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main (String[] args) {
        Logger.log(1);
        Logger.log(1);
        Logger.log("str1");
        Logger.log("str2");
        Logger.log("str2");
        Logger.flush();
    }
}