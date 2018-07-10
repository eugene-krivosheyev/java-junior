package com.acme.edu;

public class Message<T> implements TestDecorator{

    private T value;

    public Message(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void print(){
        System.out.println(value);
    }

    @Override
    public String decorate(Message message) {
        return "primitive " + value;
    }
}
