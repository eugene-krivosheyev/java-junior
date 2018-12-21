package demo.twrdemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TwrDemo {
    public static void main(String[] args) {
        try (
            Connection c = null; //factory.getConnection();
            Statement s = c.createStatement();
        ) {

            ///?????

        } catch (SQLException e) {
            e.printStackTrace();
        } //finally: c.close();
    }
}
