package com.acme.edu.exception;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.mockito.Mockito.*;

public class ExceptionDemo {
    public static void main(String... args) throws SQLException {
        //
        moneyTransfer();
        //
    }

    public static void moneyTransfer() throws SQLException {
        Connection c = mock(Connection.class);
        doThrow(new SQLException("deeeeeep")).when(c).close();

        try (Connection conn = c) {
            save();
        } catch (SQLException e) {
            throw new RuntimeException("MTE", e);
        }
    }

    private static void save() throws SQLException {
        //
        throw new SQLException("IOException");
        //
    }
}
