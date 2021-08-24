package demo.ooad.dao;

import demo.ooad.domain.Message;
import demo.ooad.validator.Validator;

public abstract class AbstractCheckingSaver implements Saver {
    private Validator validator;

    protected AbstractCheckingSaver(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void save(Message message) {
        validator.validate(message);
    }
}
