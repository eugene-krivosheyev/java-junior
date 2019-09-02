package com.acme.edu.net.main;

import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.net.Client;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> new CommandImplListener(8102)).start();

        Client client = new Client("localhost", 8102);
        IntCommand commad = new IntCommand(8);
        IntCommand commad2 = new IntCommand(8123);
        StringCommand commad3 = new StringCommand("hello");
        StringCommand commad4 = new StringCommand("privet");
        ByteCommand commad5 = new ByteCommand((byte) 76);
        client.sendCommand(commad);
        client.sendCommand(commad2);
        client.sendCommand(commad3);
        client.sendCommand(commad4);
        client.sendCommand(commad5);
    }
}
