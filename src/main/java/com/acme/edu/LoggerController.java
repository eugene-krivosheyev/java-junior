package com.acme.edu;

import com.acme.edu.message.*;

public class LoggerController {
    private Message accumulator;

    public LoggerController(){
        accumulator = null;
    }

    public void log(Message message){
        if(message.sameTypeOf(accumulator)){
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

    public void flush(){
        if(accumulator != null){
            ConsoleSaver.writeToConsole(accumulator.getDecoratedMessage());
            accumulator = null;
        }
    }
}
