package com.db.edu.command;

public class StringCommand implements Command{

    private int accumulatedValue;
    private String currentValue;
    private static final String STRING_PREFIX = "string: ";

    public StringCommand(String value){
        currentValue=value;
        accumulatedValue=1;
    }

    public Command accumulate(Command newCommand){
        if (!sameTypeOf(newCommand)) throw new IllegalArgumentException();
        accumulatedValue++;
        return this;
    }

    public boolean canAccumulate(Command newCommand){
        if (!sameTypeOf(newCommand)) return false;

        StringCommand newStringCommand = (StringCommand) newCommand;
        return newStringCommand.getCurrentValue()==currentValue;
    }

    private boolean sameTypeOf(Command newCommand){
        return newCommand instanceof StringCommand;
    }

    public String getDecoratedMessage(){
        if (accumulatedValue==1){
            return STRING_PREFIX+currentValue;
        }
        else{
            return STRING_PREFIX+currentValue+" (x"+accumulatedValue+")";
        }
    }

    public int getAccumulatedValue(){
        return accumulatedValue;
    }

    public String getCurrentValue(){
        return currentValue;
    }
}
