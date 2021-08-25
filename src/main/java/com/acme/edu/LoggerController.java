package com.acme.edu;
import com.acme.edu.messages.*;
import com.acme.edu.checkers.*;



public class LoggerController {
    private IntSequenceChecker intCheker= new IntSequenceChecker();
    private StringSequenceChecker stringChecker = new StringSequenceChecker();

    public void log(IntMessage message){
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(BoolMessage message){
        System.out.println(Type.PRIMITIVE.value + message.getValue());
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(ByteMessage message){
        System.out.println(Type.PRIMITIVE.value + message.getValue());
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(CharMessage message){
        System.out.println(Type.CHAR.value + message.getValue());
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(StringMessage message){
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(ObjectMessage message){
        System.out.println(Type.REFERENCE.value + message.getValue());
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public void flush(){
        stringChecker.check(null);
        intCheker.check(null);
    }
}