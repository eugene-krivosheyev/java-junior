package demo.polymorphism;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * [GoF] Strategy
 */
public class Dao {
    private StepStrategy step;

    public Dao(StepStrategy step) {
        this.step = step;
    }

    public void exec() {
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

interface StepStrategy {
    void doBusinessLogic();
}

class UpdateStepStrategy implements StepStrategy {
    public void doBusinessLogic() {
        //SQL UPDATE
    }
}
