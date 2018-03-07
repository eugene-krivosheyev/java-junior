package com.acme.edu.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionDemo {
    MyConnection c;
    public static void main(String[] args) {
        try (
                MyConnection c = new MyConnection();
                InputStream is = new FileInputStream(""))
        { //t-w-r
            doMediate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doMediate() {
        RuntimeException hE = null;
        try {
//            Connection c = new C();
            doBusinessLogic();
            //
        } catch (IllegalArgumentException problem) {
//            problem.printStackTrace();
            hE = new RuntimeException("hello from catch block");
            hE.addSuppressed(problem);
            throw hE;
        } catch (RuntimeException e) {

        } catch (Throwable e) {

        } finally {
//            if (c != null) try {
//                  c.close();
//            } catch
            NullPointerException nullPointerException = new NullPointerException();
            if (hE != null) nullPointerException.addSuppressed(hE);
            throw nullPointerException;
        }
    }

    private static void doBusinessLogic() {
            doDataAccess(null);
    }

    private static void doDataAccess(Integer param) {
        if (param == null) {
            throw new IllegalArgumentException("No nulls allowed!!!!");
        }

        System.out.println("end.");
    }
}

