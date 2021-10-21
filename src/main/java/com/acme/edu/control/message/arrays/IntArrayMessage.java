package com.acme.edu.control.message.arrays;

import com.acme.edu.control.message.Message;

import java.util.ArrayList;

public class IntArrayMessage extends Message {
    private int dim = 1;

    public IntArrayMessage(ArrayList msg, boolean isSum, int dim){
        type = msgType.AINT;
        setMsg(msg,isSum);
    }

    public IntArrayMessage(ArrayList msg, int dim){
        this(msg,false, dim);
    }

    public IntArrayMessage(IntArrayMessage message) {
        this((ArrayList) message.getData(), message.isSum(),message.dim);
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
    public String toString() {
        if (isSumming){
           return String.valueOf(sumInt1234D((ArrayList<Integer>)data,dim));
        } else {
            return prefix() + msgInt1234D((ArrayList<Integer>)data,dim);
        }
    }

    private int sumInt1234D(ArrayList<Integer> array, int dimension){
        int sum = 0;
        if (dimension == 1) {
            sum = sumIntArray(sum, array);
        } else {
            for (Object value : array) {
                sum = sumInt1234D((ArrayList<Integer>) value, dimension - 1);
            }
        }
        return sum;
    }

    private int sumIntArray(int sum, ArrayList<Integer> intArray){
        for (int value:intArray) { sum += value; }
        return sum;
    }

    private String msgIntArray(ArrayList<Integer> message) {
        StringBuilder msg = new StringBuilder("{");
        int len =  message.toArray().length;
        for (int i = 0; i<len; ++i) {
            msg.append(message.get(i));
            msg.append((i<len-1)?", ":"");
        }
        msg.append("}");
        return  msg.toString();
    }

    private String msgInt1234D(ArrayList<Integer> array, int dimension){
        String message = "";
        if (dimension == 1) {
            message = msgIntArray(array);
        } else {
            for (Object value : array) {
                message = msgInt1234D((ArrayList<Integer>) value, dimension - 1);
            }
        }
        return message;
    }

}
