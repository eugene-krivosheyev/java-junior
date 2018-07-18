package demo.exceptions;


import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class Demo {
    public static void main(String[] args) {
        UI ui = new UI(
                    new MoneyService(
                        new AccountDao()
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

    MoneyService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void doTransfer() throws TransferException {
        try (
            FinDao finlogDao = new FinDao();
        ) {
            accountDao.getAmount();
            finlogDao.save();
        } catch (IOException e) {
            //0. logging
            //1. Compensating TX
            //2. Re-throw
            throw new TransferException("Can't transfer", e);
        }
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

class FinDao implements Closeable {
    public void save() throws IOException {
        if (1 == 1) {
            throw new IOException("Can't open file");
            //unreachable
        }
    }

    @Override
    public void close() {

    }
}