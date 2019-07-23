package com.acme.edu.command;

import com.acme.edu.Type;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class IntMas4Command implements Command {
    private int[][][][] message ;
    private ConsoleLoggerSaver saver = null;
    private Command prevCommand = null ;

    public IntMas4Command(int[][][][] message) {
        this.message = message;
    }

    @Override
    public void accumulate(Command command, ConsoleLoggerSaver saver) {
        this.saver = saver;
        if (command instanceof NoneCommand) {
            prevCommand = this;
        } else {
            prevCommand = command;
            flush();
        }
    }

    public String messageDecorate() {
        String str= "primitives multimatrix: {"+System.lineSeparator();
        for(int[][][] i:message) {
            str=str+"{"+System.lineSeparator();
            for(int[][] j:i) {
                str=str+"{"+System.lineSeparator();
                for(int[] k:j){
                    str=str+"{";
                    for(int m:k){
                        str += m + ", ";
                    }
                    if(k.length>0)
                        str=str.substring(0,str.length()-2)+"}"+System.lineSeparator();
                    else
                        str+="}"+System.lineSeparator();
                }
                str+="}"+System.lineSeparator();
            }
            str+="}"+System.lineSeparator();
        }
        str+="}";
        return str;
    }

    @Override
    public void flush() {
        saver.save(prevCommand.messageDecorate());
        prevCommand = this;
    }

    @Override
    public Command getPrevCommand() {
        return prevCommand;
    }

}
