package com.acme.edu.net.main;

import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.net.Client;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        new CommandImplListener(8102);
        Thread.sleep(1000);
    }

}
class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Client client = new Client("localhost", 8102);
                client.sendCommand(new IntCommand(1));
                client.sendCommand(new StringCommand("aaa"));
                client.sendCommand(new StringCommand("aaa"));
                client.sendCommand(new ByteCommand((byte) 1));
            }).start();

        }
    }
}
