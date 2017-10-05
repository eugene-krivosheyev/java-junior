package com.acme.exceptionsdemo;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try (
            FileDao fileDao = new FileDao(null);
            FileInputStream is = new FileInputStream("")
        ) {
            fileDao.getData();
        } catch (DataException e) {
            e.printStackTrace();
            throw new RuntimeException("1", e);
        } catch (RuntimeException | FileNotFoundException r) {
            System.out.println("catch");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileDao implements Closeable {
    private String path;

    FileDao(String path) {
        throw new RuntimeException("Error while dao constructor");
//        this.path = path;
    }

    public String[] getData() {
        //....
        try {
            new FileInputStream("");
        } catch (FileNotFoundException e) {
            throw new DataException("error while", e);
        }

        return null;
    }

    @Override
    public void close()  {

    }
}
