package com.acme.edu;

import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;

import java.util.Objects;

public class LoggerController {
    private IntMessage intAccumulator;
    private ByteMessage byteAccumulator;
    private StringMessage stringAccumulator;

    private ClassValidator classValidator;

    public LoggerController(){
        classValidator = new ClassValidator();

        intAccumulator = null;
        byteAccumulator = null;
        stringAccumulator = null;
    }

    public void log(IntMessage message){
        if(classValidator.setCurrentClass(message)){
            if(intAccumulator != null){
                intAccumulator.accumulate(message);
            }else{
                intAccumulator = message;
            }

        }else{
            flush();
            intAccumulator = message;
        }
    }

    public void log(ByteMessage message){
        if(classValidator.setCurrentClass(message)){
            if(byteAccumulator != null){
                byteAccumulator.accumulate(message);
            }else{
                byteAccumulator = message;
            }
        }else{
            flush();
            byteAccumulator = message;
        }
    }

    public void log(StringMessage message){
        if(classValidator.setCurrentClass(message) && stringAccumulator != null && Objects.equals(stringAccumulator.getBody(), message.getBody())){
            stringAccumulator.accumulate(message);
        }else{
            flush();
            stringAccumulator = message;
        }
    }

    public void log(Message message){
        flush();
        ConsoleSaver.writeToConsole(message.getDecoratedMessage());
    }

    public void flush(){
        if(intAccumulator != null){
            ConsoleSaver.writeToConsole(intAccumulator.getDecoratedMessage());
            intAccumulator = null;
        }

        if(byteAccumulator != null){
            ConsoleSaver.writeToConsole(byteAccumulator.getDecoratedMessage());
            byteAccumulator = null;
        }

        if(stringAccumulator != null){
            ConsoleSaver.writeToConsole(stringAccumulator.getDecoratedMessage());
            stringAccumulator = null;
        }
    }
}
