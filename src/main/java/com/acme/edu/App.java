package com.acme.edu;

import java.io.*;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try(
//            ObjectOutputStream o =
//                    new ObjectOutputStream(
//                            new BufferedOutputStream(
//                                new FileOutputStream("obj.ser")));

            ObjectInputStream i =
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("obj.ser")));
        ) {

//            o.writeObject(new LogMessage("test2", 15));
//            o.writeObject(new LogMessage("test3", 1555));

            LogMessage m = (LogMessage) i.readObject();
            System.out.println(m);

            LogMessage m2 = (LogMessage) i.readObject();
            System.out.println(m2);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            Class.forName("LogMessage");
        }
    }
}

class LogMessage implements Serializable {
    public static  int II = 7;
   private String m;
   private int i;

    public LogMessage(String m, int i) {
        this.m = m;
        this.i = i;
    }

    public String getM() {
        return m;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "m='" + m + '\'' +
                ", i=" + i +
                '}';
    }
}
