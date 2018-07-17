package demo.exceptions;


import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        UI ui = new UI(
                    new MoneyService(
                        new AccountDao(),
                        new FinDao()
                    )
        );

        ui.transferMoney();
        System.out.println("Normal shutdown");
    }
}

class UI {
    private MoneyService moneyService;

    UI(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    public void transferMoney() {
        try {
            moneyService.doTransfer();
        } catch (TransferException | RuntimeException | Error e) {
            System.err.println("Keep calm and " + e.getMessage());
        }

    }
}

class MoneyService {
    private AccountDao accountDao;
    private FinDao finlogDao;

    MoneyService(AccountDao accountDao, FinDao finlogDao) {
        this.accountDao = accountDao;
        this.finlogDao = finlogDao;
    }

    public void doTransfer() throws TransferException {
        try {
            accountDao.getAmount();
            finlogDao.save();
        } catch (IOException e) {
            //0. logging
            //1. Compensating TX
            //2. Re-throw
            throw new TransferException("Can't transfer", e); //Wrapped
        }
        //unreachable
    }
}

class TransferException extends Exception {
    public TransferException(String message, Throwable cause) {
        super(message, cause);
    }
}

class AccountDao {
    public void getAmount() {

    }
}

class FinDao {
    public void save() throws IOException {
        if (1 == 1) {
            throw new IOException("Can't open file");
            //unreachable
        }
    }
}