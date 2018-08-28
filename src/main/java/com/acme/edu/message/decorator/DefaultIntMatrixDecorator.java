package com.acme.edu.message.decorator;

import com.acme.edu.MessageType;
import com.acme.edu.message.IntMatrixMessage;
import com.acme.edu.message.Message;

import java.util.Map;

public class DefaultIntMatrixDecorator implements Decorator {
    private DefaultIntArrayDecorator rowDecorator = new DefaultIntArrayDecorator();

    @Override
    public String decorate(Message message) {
        StringBuilder decoratedString = new StringBuilder("primitives matrix: ");
        decoratedString.append("{").append(System.lineSeparator());
        int[][] matrix = ((IntMatrixMessage)message).getMessage();
        for (int[] row : matrix) {
            decoratedString.append(rowDecorator.arrayToString(row))
                    .append(System.lineSeparator());
        }
        decoratedString.append("}");
        return decoratedString.toString();
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.INTMATRIX, this);
    }
}
