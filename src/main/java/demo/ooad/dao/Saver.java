package demo.ooad.dao;

import demo.ooad.domain.Message;

public interface Saver {
    void save(Message message) throws SaveException;
}
