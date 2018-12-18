package demo.exceptionsdemo;

import java.sql.Connection;
import java.sql.SQLException;

public class ExceptionsDemo {
    public static void main(String[] args) throws SQLException {
        Connection c = null;
        RuntimeException ble = null;
        try {
            c = null;
            bl(); // e ->
        } catch (IllegalArgumentException | ArithmeticException e) {
            //1. log
            //2. отказ пользователю
            ble = new RuntimeException(e);
            throw ble;
        } finally {
            NullPointerException npe = new NullPointerException();
            if (ble != null) npe.addSuppressed(ble);
            throw npe;
        }
    }

    private static void bl() {
        dal();
        // nop
    }

    private static void dal() {
        boolean isOpened = false;
        if (!isOpened) {
            throw new ArithmeticException("Can't open file!!!");
        }
        //
    }
}
