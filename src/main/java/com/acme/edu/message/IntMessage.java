package com.acme.edu.message;

//public class IntMessage extends Message {  @Override
public class IntMessage extends Message {
    private int message;
  //  int sum = 0;
    public IntMessage (int message) {
        this.message = message;
    }
    @Override
    public Message log(Message message) {
        return null;
    }
    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage; //this.getClass();
    }
    public void flush(){

    }
    @Override
    public void accumulate(Message message) {
        int value = ((IntMessage)message).message;
        this.message += value;
    }
    @Override
    public String fetch() {
        return super.getDecorator().decorate(message);
    }
}
