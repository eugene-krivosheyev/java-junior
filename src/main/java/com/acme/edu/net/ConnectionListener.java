package com.acme.edu.net;

import com.acme.edu.saver.SaverException;

public interface ConnectionListener {
    void onReceiveMessage(Connection connection, String message);
}
