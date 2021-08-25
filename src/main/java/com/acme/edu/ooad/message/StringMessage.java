package com.acme.edu.ooad.message;

public class StringMessage extends ObjectMessage{
    private final String value;
    private static int stringCounter;
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
        return stringCounter != 0 && !lastString.equals(value);
    }

    private boolean isEmptyBuffer() {
        return stringCounter == 0 || lastString.equals("");
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
        if (!isNewString()) {
            ++stringCounter;
        } else {
            // do nothing
        }
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
