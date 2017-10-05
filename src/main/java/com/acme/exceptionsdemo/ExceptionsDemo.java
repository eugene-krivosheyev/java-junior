package com.acme.exceptionsdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionsDemo {
    public static void main(String[] args) {
        FileDao fileDao = null;
        RuntimeException runtimeException = null;
        try {
            fileDao = new FileDao(null);
            fileDao.getData();
        } catch (DataException e) {
            e.printStackTrace();
            throw new RuntimeException("1", e);
        } catch (RuntimeException r) {
            System.out.println("catch");
            runtimeException = new RuntimeException("2", r);
            throw runtimeException;
        } finally {
            System.out.println("finally");
            if (fileDao != null) {
                try {
                    fileDao.close(); //Suppression by NPE
                } catch (Exception e) {
                    if (runtimeException != null) {
                        e.addSuppressed(runtimeException);
                    }
                    throw e;
                }
            }
        }
    }
}

class FileDao {
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

    public void close() {

    }
}
