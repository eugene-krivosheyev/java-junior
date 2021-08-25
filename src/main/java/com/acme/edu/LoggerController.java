package com.acme.edu;

import com.acme.edu.message.*;

import java.util.*;

public class LoggerController {
    private Queue<Message> messageQueue;
    private Message accumulator;

    private ClassValidator classValidator;

    public LoggerController(){
        classValidator = new ClassValidator();
        accumulator = null;
        messageQueue = new LinkedList<>();
    }

    public void log(IntMessage message){
        if(classValidator.setCurrentClass(message)){
            if(accumulator != null){
                accumulator.accumulate(message);
            }else{
                accumulator = message;
            }

        }else{
            flush();
            accumulator = message;
        }
    }

    public void log(ByteMessage message){
        if(classValidator.setCurrentClass(message)){
            if(accumulator != null){
                accumulator.accumulate(message);
            }else{
                accumulator = message;
            }
        }else{
            flush();
            accumulator = message;
        }
    }

    public void log(StringMessage message){
        if(classValidator.setCurrentClass(message) && accumulator != null && Objects.equals(accumulator.getBody(), message.getBody())){
            accumulator.accumulate(message);
        }else{
            flush();
            accumulator = message;
        }
    }

    public void log(Message message){
        flush();

        if(classValidator.checkValidatorIsNull() | classValidator.setCurrentClass(message)){
            messageQueue.add(message);
        }else{
            flush();
            messageQueue.add(message);

        }
    }

    public void flush(){
        // TODO
        Message resultMessage = null;
        ConsoleSaver.writeToConsole(resultMessage.getDecoratedMessage());

        messageQueue.clear();
    }
}
