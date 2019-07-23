package com.acme.edu.exception;

import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class ExceptionDemo {
    public static void main(String... args) throws SQLException {
        //
        moneyTransfer();
        //
    }

    public static void moneyTransfer() throws SQLException {
        Connection c = mock(Connection.class);
        doThrow(new SQLException()).when(c).close();

        RuntimeException mte = null;
        try {
            //
            save(); //RE("t")
            //
        } catch (RuntimeException e) {
            //log
            mte = new RuntimeException("MTException", e);
            throw mte; //re-throw
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    if (mte != null) e.addSuppressed(mte);
                    throw e;
                }
            }
        }
    }

    private static void save() {
        //
        throw new RuntimeException("IOException");
        //
    }
}
