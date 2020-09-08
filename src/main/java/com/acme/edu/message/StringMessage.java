package com.acme.edu.message;

import java.util.ArrayList;

import static java.lang.System.lineSeparator;

public class StringMessage implements AbstractMessage{
    static public String PREFIX = "string: ";

    public StringMessage(ArrayList<Object> listOfLog) {
        messageController.setLength(0);
        prepareMessage(listOfLog);
    }

    @Override
    public void prepareMessage(ArrayList<Object> listOfLog) {
        String templateMultiple = PREFIX + "%s " + "(x%o)";
        String templateUnique = PREFIX + "%s";
        //System.out.println(PREFIX);
        String prevValue = (String) listOfLog.get(0);
        int counter = 0;

        for (int i = 0; i < listOfLog.size(); i++) {
            String currentValue = (String) listOfLog.get(i);
            if (i == listOfLog.size() - 1) {
                messageController
                        .append(counter == 0 ?
                                String.format(templateUnique, currentValue) :
                                String.format(templateMultiple, currentValue, counter + 1))
                        .append(lineSeparator());
            } else {
                if (currentValue.equals(prevValue)) {
                    counter += 1;
                } else {
                    messageController
                            .append(counter == 1 ?
                                    String.format(templateUnique, prevValue) :
                                    String.format(templateMultiple, prevValue, counter))
                            .append(lineSeparator());
                }
                prevValue = currentValue;
            }
        }
        messageController.delete(messageController.length()-2, messageController.length());
    }
}
