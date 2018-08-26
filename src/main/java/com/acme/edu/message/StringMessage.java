package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class StringMessage implements  Message{

    private String value;
    private static ArrayList<String> arrayOfStrings = new ArrayList<>();
    private static ArrayList<String> arrayOfUniqueString = new ArrayList<>();
    private static ArrayList<Integer> amountOfString = new ArrayList<>();
    private String result = "";

    private static final String STRING = "string: ";

    public StringMessage(String message) {
        this.value = message;
        arrayOfStrings.add(value);
        if (!arrayOfUniqueString.contains(value)){
            arrayOfUniqueString.add(value);
        }
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public String getDecoratedMessage(){
        for (String string : arrayOfUniqueString){
            amountOfString.add(Collections.frequency(arrayOfStrings, string));
        }

        int i = 0;
        do {
            int index = amountOfString.get(i);
            String times = index > 1 ? " (x"+index + ")\n" : "\n";
            String value = arrayOfUniqueString.get(i);
            result = result.concat(value + times);
            i ++;
        } while (i < amountOfString.size());
        arrayOfStrings.clear();
        arrayOfUniqueString.clear();
        amountOfString.clear();
        return STRING + result;
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    public String getValue() {
        return value;
    }
}

