package com.acme.edu;
import com.acme.edu.messages.*;
import com.acme.edu.checkers.*;
import com.acme.edu.savers.Saver;


public class LoggerController {
    Saver saver;
    private IntSequenceChecker intCheker;
    private StringSequenceChecker stringChecker;

    public LoggerController(Saver saver) {
        this.saver = saver;
        this.intCheker = new IntSequenceChecker(this.saver);
        this.stringChecker = new StringSequenceChecker(this.saver);
    }


    public void log(IntMessage message){
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(BoolMessage message){
        saver.save(Type.PRIMITIVE.value + message.getValue());
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(ByteMessage message){
        saver.save(Type.PRIMITIVE.value + message.getValue());
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(CharMessage message){
        saver.save(Type.CHAR.value + message.getValue());
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(StringMessage message){
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public  void log(ObjectMessage message){
        saver.save(Type.REFERENCE.value + message.getValue());
        stringChecker.check(message.getValue());
        intCheker.check(message.getValue());
    }

    public void flush(){
        stringChecker.check(null);
        intCheker.check(null);
    }
}