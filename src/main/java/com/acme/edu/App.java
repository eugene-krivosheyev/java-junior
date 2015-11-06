package com.acme.edu;

import java.io.*;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        try(
            FileReader fr = new FileReader("temp.txt");
            BufferedReader br = new BufferedReader(fr);
            RandomAccessFile f = new RandomAccessFile("temp.txt", "r");
        ) {

            String readLine;
            while((readLine = br.readLine()) != null) {
                if(!"".equals(readLine)) System.out.println(">>>>" + readLine);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
