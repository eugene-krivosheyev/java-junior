package com.acme.edu.exception;


public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            doMediate();
        } catch (MoneyTransferException e) {
            e.printStackTrace();
        }
    }

    private static void doMediate() throws MoneyTransferException {
        doBusinessLogic();
    }

    private static void doBusinessLogic() throws MoneyTransferException { //re-throw: encapsulation errors
        try {
            doDataAccess(null);
        } catch (IllegalArgumentException e) {
            throw new MoneyTransferException("Can't transfer money", e); //Business Operation error
        }
    }

    private static void doDataAccess(Integer param) {
        if (param == null) {
            throw new IllegalArgumentException("No nulls allowed!!!!");
        }

        System.out.println("end.");
    }
}


class DAO {
    public void saveDate() throws SaveOperationException {

    }
}

class FileDAO extends DAO {
    @Override
    public void saveDate() throws FileNotFoundWxception, FileOpeningException {
        try {
            super.saveDate();
        } catch (SaveOperationException e) {
            throw new FileNotFoundWxception(e);
        }
    }
}
