package com.db.education.app.message;

public class EmptyMessage implements Message{
    @Override
    public boolean accumulate(Message message) { return true; }
}
