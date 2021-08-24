package demo.ooad.validator;

import demo.ooad.domain.Message;

public class EmptynessValidator implements Validator {
    @Override
    public void validate(Message message) {
        if (message == null ||
            message.getBody() == null ||
            message.getBody().isEmpty()) {
                throw new IllegalArgumentException("null!!!");
        }
    }
}
