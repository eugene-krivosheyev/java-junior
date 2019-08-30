package com.acme.edu.net.main;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.net.Client;
import com.acme.edu.net.Connection;
import com.acme.edu.net.ConnectionListener;
import com.acme.edu.net.Server;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.SaverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NetManager  implements ConnectionListener {

    private static final Logger log = LoggerFactory.getLogger(NetManager.class);
    private LoggerController loggerController = new LoggerController(new ConsoleSaver());
    private Server server;

    public NetManager() { server = new Server( this, 8100); }

    public static void main(String[] args) {
        new Thread(() -> new NetManager()).start();
        new Client();
    }

    @Override
    public synchronized void onConnectionReady(Connection connection) {
        server.getConnections().add(connection);
    }

    @Override
    public synchronized void onReceiveString(Connection connection, String message) {
        log.info("Пришло сообщение: " + message + ", от: " + connection.toString());
        try {
            loggerController.handleCommand(selectComand(message));
        } catch (SaverException e) {
            onException(connection, e);
        }
        sendMessage("Cообщение: " + message + " - было отправлено", connection);
    }

    @Override
    public synchronized void onDisconnect(Connection connection) {
        server.getConnections().remove(connection);
    }

    @Override
    public synchronized void onException(Connection connection, Exception ex) {
        log.error("Ошибка создания соединения: " + ex);
    }

    private void sendMessage(String msg, Connection connection) {
        connection.sendMessage(msg);
    }

    private Command selectComand(String message) {
        try {
            byte result = Byte.parseByte(message);
            return new ByteCommand(result);
        } catch (NumberFormatException e) {
            try {
                int result = Integer.parseInt(message);
                return new IntCommand(result);
            } catch (NumberFormatException t) {
                String result = String.valueOf(message);
                return new StringCommand(result);
            }
        }
    }
}
