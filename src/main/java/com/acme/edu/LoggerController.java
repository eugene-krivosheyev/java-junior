package com.acme.edu;

import com.acme.edu.handlers.StringHandler;
import com.acme.edu.messages.*;
import com.acme.edu.handlers.ByteOverflowHandler;
import com.acme.edu.handlers.IntegerOverflowHandler;
import com.acme.edu.handlers.OverflowHandler;
import com.acme.edu.savers.Saver;

import java.util.Arrays;

import static com.acme.edu.LoggerState.*;

public class LoggerController {
    private Message currentMessage = null;

    private boolean printAsArrayToggle = false;
    private final String LINE_SEPARATOR = System.lineSeparator();

    private final Saver saver;
    private final OverflowHandler integerOverflow = new IntegerOverflowHandler();
    private final OverflowHandler byteOverflow = new ByteOverflowHandler();
    private final StringHandler stringHandler = new StringHandler();
    private LoggerState state = DEFAULT;

    LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(int message) {
        if (!state.equals(LAST_INTEGER)) {
            flush();
            state = LAST_INTEGER;
        }
        printOverflowIfNeeded(integerOverflow.handleOverflow(message));
        currentMessage = integerOverflow.getMessage();
    }

    public void log(byte message) {
        if (!state.equals(LAST_BYTE)) {
            flush();
            state = LAST_BYTE;
        }
        printOverflowIfNeeded(byteOverflow.handleOverflow(message));
        currentMessage = byteOverflow.getMessage();
    }

    public void log(char message) {
        print(new CharacterMessage(message).getMessageAsString());
    }

    public void log(String message) {
        if (!(state.equals(LAST_STRING) && stringHandler.isEqualToLast(message))) {
            flush();
            stringHandler.setLastSubmittedString(message);
        }
        currentMessage = stringHandler.getMessage();
        state = LAST_STRING;
    }

    public void log(String... strings) {
        Arrays.stream(strings).forEach(Logger::log);
    }

    public void setArrayToggle() {
        printAsArrayToggle = true;
    }

    public void log(int... integers) {
        if (!printAsArrayToggle) {
            accumTheSum(integers);
        } else {
            print(new PrimitiveArrayMessage(makeTheString(integers)).getMessageAsString());
            printAsArrayToggle = false;
        }
    }

    public void log(int[][] integers) {
        if (!printAsArrayToggle) {
            for (int[] row : integers) {
                accumTheSum(row);
            }
        } else {
            print(new PrimitiveMatrixMessage(make2DString(integers)).getMessageAsString());
            printAsArrayToggle = false;
        }
    }

    public void log(boolean message) {
        print(new BooleanMessage(message).getMessageAsString());
    }

    public void log(Object message) {
        print(new ObjectRefMessage(message.toString()).getMessageAsString());
    }

    public void flush() {
        if (currentMessage != null) {
            print(currentMessage.getMessageAsString());
        }
        clearOverflows();
        currentMessage = null;
    }

    private void clearOverflows() {
        integerOverflow.clear();
        byteOverflow.clear();
    }

    private void accumTheSum(int[] array) {
        for (int j : array) {
            log(j);
        }
    }

    private String makeTheString(int[] array) {
        StringBuilder arrayToString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arrayToString.append("{");
            }
            arrayToString.append(array[i]);
            if (i != array.length - 1) {
                arrayToString.append(", ");
            } else {
                arrayToString.append("}");
            }
        }
        return (arrayToString.toString());
    }

    private String make2DString(int[][] array) {
        StringBuilder arrayTo2DString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arrayTo2DString.append("{" + LINE_SEPARATOR);
            }
            arrayTo2DString.append(makeTheString(array[i]) + LINE_SEPARATOR);
            if (i == array.length - 1) {
                arrayTo2DString.append("}" + LINE_SEPARATOR);
            }
        }
        return arrayTo2DString.toString();
    }

    private void print(String message) {
        saver.print(message);
    }

    private void printOverflowIfNeeded(String handleOverflow) {
        if (handleOverflow != null) {
            saver.print(handleOverflow);
        }
    }
}
