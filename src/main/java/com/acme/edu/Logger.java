package com.acme.edu;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ControllerState());

//    private static void typeSwitcher(MessageTypeName typeName) {
//        isPrimitiveCount++;
//        if (prevTypeName.equals(typeName)) return;
//        switch (prevTypeName) {
//            case INT:
//            case BYTE: {
//                accumulatedStr += accumulatedSum + lineSeparator();
//                accumulatedSum = 0;
//                break;
//            }
//            case STRING: {
//                accumulatedStr += previousStr;
//                if (sameStringsAmount > 1) {
//                    accumulatedStr += " (x" + sameStringsAmount + ")";
//                }
//                accumulatedStr += lineSeparator();
//                previousStr = "";
//                sameStringsAmount = 0;
//            }
//            default:
//        }
//    }

    public static void log(int message) {
        loggerController.proceed(new CommandMessageInt(message));
//        typeSwitcher(INT);
//        prevTypeName = INT;
//        if (message > 0) {
//            if (accumulatedSum > Integer.MAX_VALUE - message) {
//                accumulatedStr += accumulatedSum + lineSeparator();
//                accumulatedSum = Integer.MAX_VALUE;
//            } else {
//                accumulatedSum += message;
//            }
//        } else {
//            if (accumulatedSum < Integer.MIN_VALUE - message) {
//                accumulatedStr += accumulatedSum + lineSeparator();
//                accumulatedSum = Integer.MIN_VALUE;
//            } else {
//                accumulatedSum += message;
//            }
//        }
    }

    public static void log(byte message) {
//        typeSwitcher(BYTE);
//        prevTypeName = BYTE;
//        if (message > 0) {
//            if (accumulatedSum > Byte.MAX_VALUE - message) {
//                accumulatedStr += accumulatedSum + lineSeparator();
//                accumulatedSum = Byte.MAX_VALUE;
//            } else {
//                accumulatedSum += message;
//            }
//        } else {
//            if (accumulatedSum < Byte.MIN_VALUE - message) {
//                accumulatedStr += accumulatedSum + lineSeparator();
//                accumulatedSum = Byte.MIN_VALUE;
//            } else {
//                accumulatedSum += message;
//            }
//        }
    }

    public static void log(char message) {
//        System.out.println("char: " + message);
//    }
//
//    public static void log(String message) {
//        typeSwitcher(STRING);
//        prevTypeName = STRING;
//        if (previousStr.equals(message)) {
//            sameStringsAmount++;
//            return;
//        }
//        if (!previousStr.equals("")) {
//            accumulatedStr += previousStr +
//                    (sameStringsAmount > 1 ? " (x" + sameStringsAmount + ")" : "") +
//                    lineSeparator();
//        }
//        previousStr = message;
//        sameStringsAmount = 1;
    }

    public static void log(boolean message) {
        //System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
//        if (message == null) {
//            message = "null";
//        }
//        System.out.println("reference: " + message);
    }

    public static void log(int[] array) {
//        System.out.println(("primitives array: " + String.join(lineSeparator(), Arrays.toString(array)))
//                .replace('[', '{')
//                .replace(']', '}'));
    }

    public static void log(String message) {
        loggerController.proceed(new CommandMessageString(message));
    }

    public static void flush() {
//        System.out.println(loggerController.getAccumulatedString());
//        if (isPrimitiveCount > 1) {
//            isPrimitive = false;
//        }
//        typeSwitcher(INITIAL);
        //System.out.print(decorator(accumulatedStr, prevTypeName));
        loggerController.finishString();
        System.out.print(loggerController.decorator(loggerController.getAccumulatedString(), loggerController.getLogCount()));
//        accumulatedStr = "";
//        accumulatedSum = 0;
//        previousStr = "";
//        prevTypeName = INITIAL;
//        isPrimitive = true;
//        isPrimitiveCount = 0;
    }
}
