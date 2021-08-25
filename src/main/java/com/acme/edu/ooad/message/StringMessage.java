package com.acme.edu.ooad.message;

import java.util.Objects;

public class StringMessage extends ObjectMessage{
    private final String value;
    private static int stringCounter = 0;
    private static String lastString;

    public StringMessage(String value) {
        super("string: ");
        this.value = value;
    }

    @Override
    public String toString() {
        return prefix + lastString + (stringCounter > 1 ? " (x" + stringCounter + ")" : "");
    }

//    @Override
//    public StringMessage flush() {
//        StringMessage message = null;
//        if (!isEmptyBuffer()) {
//            message = this;
//        }
//        clean();
//        return message;
//    }

    public void clean() {
        stringCounter = 0;
    }

    /*private*/public boolean isNewString() {
        if (lastString == null) {
            return true;
        }
        return stringCounter != 0 && !Objects.equals(lastString,value);
    }

    private boolean isEmptyBuffer() {
        return stringCounter == 0 || Objects.equals(lastString,"");
    }

//    public StringMessage process(/*String message*/) {
//        StringMessage result = null;
//        if (isNewString()) {
//            result = flush();
//        }
//
////        lastString = value;
//        ++stringCounter;
//
//        return result;
//    }
    public void process() {
  //      if (isNewString()) {
             lastString = value;
  //      }
        ++stringCounter;
    }


//    public ObjectMessage[] process(String... messages) {
//        ObjectMessage[][] processArrays = new ObjectMessage[messages.length][];
//
//        int resultLength = 0;
//        for (int i = 0; i < messages.length; ++i) {
//            processArrays[i] = process(messages[i]);
//            resultLength += processArrays[i] == null ? 0 : processArrays[i].length;
//        }
//
//        ObjectMessage[] result = new ObjectMessage[resultLength];
//        int resultIterator = 0;
//
//        for (ObjectMessage[] processArray : processArrays) {
//            if (processArray == null) continue;
//            for (ObjectMessage objectMessage : processArray) {
//                result[resultIterator] = objectMessage;
//                ++resultIterator;
//            }
//        }
//
//        return result;
//    }
}
