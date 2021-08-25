package com.db.edu.command;

public class IntCommand implements Command{

    private int accumulatedValue;
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    public IntCommand(int value){
        accumulatedValue = value;
    }

    public Command accumulate(Command newCommand){
        if (!sameTypeOf(newCommand)) throw new IllegalArgumentException();
        accumulatedValue+=((IntCommand)newCommand).getAccumulatedValue();
        return this;
    }

    public boolean canAccumulate(Command newCommand){
        return sameTypeOf(newCommand);
    }

    private boolean sameTypeOf(Command newCommand){
        return newCommand instanceof IntCommand;
    }

    public String getDecoratedMessage(){
        return PRIMITIVE_PREFIX+accumulatedValue;
    }

    public int getAccumulatedValue(){
        return accumulatedValue;
    }
}
