package demo.ooad.filter;

import demo.ooad.domain.Message;
import demo.ooad.validator.EmptynessValidator;
import demo.ooad.validator.Validator;

public class ContentFilter implements Filter {
    private final String mustNotContain; //blank final
    private final Validator validator;

    public ContentFilter(String mustNotContain, Validator validator) {
        this.mustNotContain = mustNotContain;
        this.validator = validator;
    }

    @Override
    public boolean filter(final Message message) {
        validator.validate(message);
        return message.getBody().contains(mustNotContain);
    }
}
