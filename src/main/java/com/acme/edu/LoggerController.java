package com.acme.edu;

public class LoggerController {
    private Accumulator localState = new Accumulator();
    private ConsoleLoggerSaver loggerSaver = new ConsoleLoggerSaver();

    public void log(IntCommand command) {
        if(!localState.accumulate(command)){
            flush();
            localState.accumulate(command);
        }
    }

    public void log(ByteCommand command) {
        if(!localState.accumulate(command)){
            flush();
            localState.accumulate(command);
        }
    }

    public void log(StringCommand command) {
        if(!localState.accumulate(command)){
            flush();
            localState.accumulate(command);
        }
    }

    public void log(CharCommand command) {
        if(!localState.accumulate(command)){
            flush();
            localState.accumulate(command);
        }
    }

    public void log(BooleanCommand command) {
        if(!localState.accumulate(command)){
            flush();
            localState.accumulate(command);
        }
    }

    public void log(ObjectCommand command) {
        if(!localState.accumulate(command)){
            flush();
            localState.accumulate(command);
        }
    }

    public void flush(){
        loggerSaver.save(localState);
    }
}
