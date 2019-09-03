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
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.SaverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class CommandImplListener implements ConnectionListener {
    private static final Logger log = LoggerFactory.getLogger(CommandImplListener.class);
    private LoggerController loggerController = new LoggerController(new FileSaver());
    private Map<Connection, List<Command>> bufferForConnection = new HashMap();

    public CommandImplListener(int port) { new Server( this, port); }

    @Override
    public synchronized void onReceiveMessage(Connection connection, String message) {
        try {
            if (message != null) {
                log.info("Пришло сообщение: " + message + ", от: " + connection.toString());
                if (!bufferForConnection.keySet().contains(connection))
                    bufferForConnection.put(connection, new LinkedList<>());
                bufferForConnection.put(connection,
                        loggerController.handleCommand(selectCommand(message), bufferForConnection.get(connection)));
                sendMessage("Cообщение залогировано: " + message, connection);
            } else {
                connection.disconnect();
            }
        } catch (SaverException e) {
            log.error("Ошибка cохранения: " + e);
        }
    }

    private synchronized void sendMessage(String msg, Connection connection) {
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
