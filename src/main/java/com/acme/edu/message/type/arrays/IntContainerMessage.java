package com.acme.edu.message.type.arrays;

import com.acme.edu.message.Message;

public class IntContainerMessage extends Message {
    private final int DIM;

    public IntContainerMessage(Object msg, boolean isSum, int dim){
        setMsg(msg,isSum);
        DIM = dim;
    }

    public IntContainerMessage(Object msg, int dim){
        this(msg,false, dim);
    }

    public IntContainerMessage(IntContainerMessage message) {
        this(message.getData(), message.isSum(),message.DIM);
    }

    @Override
    public void setMsg(Object message) {
        data = message;
    }

    @Override
    public void setMsg(Object message, boolean isSum) {
        setMsg(message);
        isSumming = isSum;
    }

    @Override
    public Message add(Message msg) {return this;}

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntContainerMessage;
    }

    @Override
    public String toString() {
        if (isSumming){
           return String.valueOf(sumContainer( data,DIM));
        } else {
            return prefix() + msgContainer(data,DIM);
        }
    }

    private int sumContainer(Object array, int dimension){
        int sum = 0;
        if (dimension == 1) {
            sum = sumIntArray(sum, (int[])array);
        } else {
            for (Object value : (Object[]) array) {
                sum = sumContainer(value, dimension - 1);
            }
        }
        return sum;
    }

    private int sumIntArray(int sum, int[] intArray){
        for (int value:intArray) { sum += value; }
        return sum;
    }

    private String msgIntArray(int[] message) {
        StringBuilder msg = new StringBuilder("{");
        int len =  message.length;
        for (int i = 0; i<len; ++i) {
            msg.append(message[i]);
            msg.append((i<len-1)?", ":"");
        }
        msg.append("}");
        return  msg.toString();
    }

    private String msgContainer(Object array, int dimension){
        StringBuilder message = new StringBuilder("{"+SEP);
        if (dimension == 1) {
            message = new StringBuilder(msgIntArray((int[]) array));
        } else {
            for (Object value : (Object[])array) {
                message.append(msgContainer(value, dimension - 1)).append(SEP);
            }
            message.append("}");
        }
        return message.toString();
    }

    @Override
    public String prefix() {
        String extra = "";
        switch (DIM){
            case 1:{extra = "s array";      }break;
            case 2:{extra = "s matrix";     }break;
            case 3:{extra = "s cube";       }break;
            case 4:{extra = "s multimatrix";}break;
        }
        return String.format("primitive%s: ",extra);
    }
}
