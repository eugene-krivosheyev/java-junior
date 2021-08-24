package demo.ooad.dao;

import demo.ooad.domain.Message;
import demo.ooad.validator.EmptynessValidator;

public class ConsoleSaver extends AbstractCheckingSaver {
    public ConsoleSaver() {
        super(new EmptynessValidator());
    }

    @Override
    public void save(Message message) {
        super.save(message);
        System.out.println(message.toString());
    }
}
