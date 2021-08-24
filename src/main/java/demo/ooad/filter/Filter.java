package demo.ooad.filter;

import demo.ooad.domain.Message;

public interface Filter {
    boolean filter(Message message);
}
