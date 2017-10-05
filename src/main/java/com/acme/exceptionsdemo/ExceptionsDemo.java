package com.acme.exceptionsdemo;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class FileDao implements Closeable {
    private String path;

    FileDao(String path) throws Exception {
        throw new Exception("Error while dao constructor");
//        this.path = path;
    }

    public String[] getData() throws DataException {
        //....
        try {
            new FileInputStream("");
            /*
            is.getByte();
            if (someFlag != someState) throw new IllegalStateException();
            */
        } catch (FileNotFoundException e) {
            throw new DataException("error while", e);
        } catch (IOException e) {
            throw new DataException(e);
        }

        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
