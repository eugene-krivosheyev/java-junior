package com.acme.edu.net.main;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.ReferenceCommand;
import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.net.Connection;
import com.acme.edu.net.ConnectionListener;
import com.acme.edu.net.Server;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.SaverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommandImplListener implements ConnectionListener {
    private static final Logger log = LoggerFactory.getLogger(CommandImplListener.class);
    private LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public CommandImplListener(int port) { new Server( this, port); }

    @Override
    public synchronized void onReceiveMessage(Connection connection, String message) {
        log.info("Пришло сообщение: " + message + ", от: " + connection.toString());
        try {
            loggerController.handleCommand(selectCommand(message));
            sendMessage("Cообщение залогировано: " + message, connection);
        } catch (SaverException e) {
            log.error("Ошибка cохранения: " + e);
        }
    }

    private void sendMessage(String msg, Connection connection) {
        connection.sendMessage(msg);
    }

    private Command selectCommand(String message) {
        String[] arr = message.split(":");
        switch (arr[1]) {
            case "STR":
                return new StringCommand(arr[0]);
            case "INT":
                return new IntCommand(Integer.parseInt(arr[0]));
            case "BYTE":
                return new ByteCommand(Byte.parseByte(arr[0]));
            default:
                return new ReferenceCommand(arr[0]);
        }
    }
}
