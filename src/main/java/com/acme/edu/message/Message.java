package com.acme.edu.message;

public interface Message {
    public Message log(Message message);
    //{return this;}
    public boolean isSameTypeOf(Message message);
    //{return true;}
    public void flush();
    public void accumulate(Message message);
    public String fetch();
    //{}
}
