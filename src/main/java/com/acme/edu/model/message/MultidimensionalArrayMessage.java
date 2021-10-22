package com.acme.edu.model.message;

import com.acme.edu.model.MessageContainer;


public class MultidimensionalArrayMessage implements Message {
    private final MessageContainer[] containers;

    public MultidimensionalArrayMessage(int[][] matrix) {
        this.containers = new MessageContainer[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            containers[i] = initContainer(matrix[i]);
        }
    }


    private static MessageContainer initContainer(int[] intArray) {
        MessageContainer container = new MessageContainer();
        for (int message : intArray) {
            container.addMessage(new IntMessageWithStringValue(String.valueOf(message)));
        }
        return container;
    }

    @Override
    public Message getJoinedMessage(Message message) {
        return null;
    }

    @Override
    public boolean canJoinMessage(Message message) {
        return false;
    }
}
