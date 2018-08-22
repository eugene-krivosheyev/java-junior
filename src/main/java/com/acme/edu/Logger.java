package com.acme.edu;

import java.util.Stack;

public class Logger {
    private static final String PRIMITIVE = "primitive";
    private static final String CHAR = "char";
    private static final String STRING = "string";
    private static final String REFERENCE = "reference";

    private  static  Stack<Object> objectStack = new Stack<Object>();

    public static void flush() {
        Object currentElement = null;
        /*objectStack.push(10);
        objectStack.push("a1");
        objectStack.push("a1");
        objectStack.push("a2");*/
        while(!objectStack.empty())
        {
            currentElement = objectStack.pop();
            //System.out.println(currentElement.getClass());
            if(currentElement.getClass() == Integer.class || currentElement.getClass() == Byte.class)
            {
                save(PRIMITIVE, currentElement.toString());
            }
            else if(currentElement.getClass() == String.class)
            {
                int numberOfEncounters = 1;
                while(!objectStack.empty() && objectStack.peek().getClass() == String.class && objectStack.peek().toString().equals(currentElement.toString()))
                {
                    objectStack.pop();
                    numberOfEncounters++;
                }
                String resultString = currentElement.toString();
                if(numberOfEncounters > 1)
                    resultString = resultString + " (x" + numberOfEncounters + ")";
                save(STRING, resultString);
            }
        }
    }

    public static void log(int message) {
        if(objectStack.empty())
        {
            objectStack.push(message);
            return;
        }
        if (objectStack.peek().getClass() != Integer.class)
        {
            flush();
            objectStack.push(message);
            return;
        }

        int tempResult = Integer.valueOf(objectStack.pop().toString());
        if (tempResult + message >= tempResult)
        {
            objectStack.push(tempResult + message);
        }
        else
        {
            objectStack.push(Integer.MAX_VALUE);
            flush();
            int result = message - (Integer.MAX_VALUE - tempResult);
            objectStack.push(result);
        }
        //save(PRIMITIVE, Integer.toString(message));
    }

    public static void log(byte message) {
        if(objectStack.empty())
        {
            objectStack.push(message);
            return;
        }
        if (objectStack.peek().getClass() != Byte.class)
        {
            flush();
            objectStack.push(message);
            return;
        }

        byte tempResult = Byte.valueOf(objectStack.pop().toString());
        if ( (byte)(tempResult + message) >= tempResult)
        {
            objectStack.push(tempResult + message);
        }
        else
        {
            objectStack.push(Byte.MAX_VALUE);
            flush();
            int result = message - (Byte.MAX_VALUE - tempResult);
            objectStack.push(result);
        }
       // save(PRIMITIVE, Byte.toString(message));
    }

    public static void log(char message) {
        save(CHAR, Character.toString(message));
    }

    public static void log(boolean message) {
        save(PRIMITIVE, Boolean.toString(message));
    }

    public static void log(String message) {
        if(objectStack.empty() || objectStack.peek().getClass() == String.class)
        {
            objectStack.push(message);
        }
        else
        {
            flush();
            objectStack.push(message);
        }
    }

    public static void log(Object message) {
        save(REFERENCE, message.toString());
    }

    private static void save(String type, String message) {
        System.out.println(type + ": " + message);
    }

}
