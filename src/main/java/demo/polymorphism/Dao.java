package demo.polymorphism;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * [GoF] Strategy
 */
public class Dao {
       public void exec(StepStrategy step) {
        Connection c = null;
        try {

            step.doBusinessLogic(); //Strategy [GoF]

            SQLWarning nextWarning = c.getWarnings().getNextWarning();
            while (nextWarning != null) {

            }
        } catch (SQLException e) {
            SQLException nextException = e.getNextException();
            while (nextException != null) {

            }
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                SQLException nextException = e.getNextException();
                while (nextException != null) {

                }
            }
        }
    }
}

@FunctionalInterface
interface StepStrategy {
    int I = 0;
    void doBusinessLogic(String param);

    static void sm() {
        System.out.println();
    }

    default void im() {
        this.doBusinessLogic("");
    }
}

class Test {
    public static void main(String[] args) {
        Dao dao = new Dao();
        dao.exec(param -> System.out.println(param));
    }
}
