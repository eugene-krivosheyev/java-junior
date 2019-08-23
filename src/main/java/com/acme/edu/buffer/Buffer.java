package com.acme.edu.buffer;

import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;

public class Buffer {

    private byte[] byteBuffer;
    private int[] intBuffer;
    private String[] stringBuffer;

    private int counterOfStrings;

    private static BufferState state;

    private static final Buffer buffer = new Buffer();

    private Buffer() {
        state = BufferState.NONE;
        counterOfStrings = 0;
        byteBuffer = new byte[1];
        intBuffer = new int[1];
        stringBuffer = new String[1];
    }

    public static Buffer getInstance() { return buffer; }

    public static void addInBuffer(String message) {
        if(message.equals(buffer.stringBuffer[0])) {
            buffer.counterOfStrings++;
        }
        else {
            if (buffer.stringBuffer[0] != null) { new ConsoleSaver().saveWithoutPrefix(new StringCommand(clearBufferStr())); }
            buffer.stringBuffer[0] = message;
            buffer.counterOfStrings = 1;
        }
    }

    public static void addInBuffer(int message) {
        ControllerOverflow.controlOverflow(message, () -> new ConsoleSaver().saveWithoutPrefix(new IntCommand(clearBufferInt())), buffer.intBuffer);
    }

    public static void addInBuffer(byte message) {
        ControllerOverflow.controlOverflow(message, () -> new ConsoleSaver().saveWithoutPrefix(new ByteCommand(clearBufferByte())), buffer.byteBuffer);
    }

    private static Byte clearBufferByte() {
        Byte result = buffer.byteBuffer[0];
        buffer.byteBuffer[0] = 0;
        return result;
    }

    private static String clearBufferStr() {
        String result;
        if(buffer.counterOfStrings > 1) {
            result = buffer.stringBuffer[0] + " (x" + buffer.counterOfStrings + ")";
        }
        else {
            result = buffer.stringBuffer[0];
        }
        buffer.stringBuffer[0] = null;
        buffer.counterOfStrings = 0;
        return result;
    }

    private static int clearBufferInt() {
        int result = buffer.intBuffer[0];
        buffer.intBuffer[0] = 0;
        return result;
    }

    private static void setState(BufferState newState) {
        switch (state){
            case BYTE:
                new ConsoleSaver().saveWithoutPrefix(new ByteCommand(clearBufferByte()));
                break;
            case INT:
                new ConsoleSaver().saveWithoutPrefix(new IntCommand(clearBufferInt()));
                break;
            case STR:
                new ConsoleSaver().saveWithoutPrefix(new StringCommand(clearBufferStr()));
                break;
            default:
                break;
        }
        state = newState;
    }

    private static BufferState getState() { return state; }

    public void changeState(BufferState state, AdderBuffer adderBuffer) {
        if(getState() != state) setState(state);
        if (adderBuffer!=null) adderBuffer.add();
    }
}
