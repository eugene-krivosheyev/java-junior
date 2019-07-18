package com.acme.edu;

public class Accumulator {
    private int intBuff = 0;
    private byte byteBuff = 0;


    private String strBuff = "";
    private int strCount = 0;

    private Type currentType = Type.NONE;


    private String currentMessage = null;

    public String getCurrentMessage() {
        return currentMessage;
    }

    public boolean accumulate(IntCommand command) {
        if (currentType.equals(Type.NONE))
            currentType = command.getType();
        if (isAccumulative(command)) {
            intBuff += command.getIntValue();
            currentMessage = command.messageDecorate(intBuff);
            return true;
        } else {
            return false;
        }
    }

    public boolean accumulate(ByteCommand command) {
        if (currentType.equals(Type.NONE))
            currentType = command.getType();
        if (isAccumulative(command)) {
            byteBuff += command.getByteValue();
            currentMessage = command.messageDecorate(byteBuff);
            return true;
        } else {
            return false;
        }
    }

    public boolean accumulate(StringCommand command) {
        if (currentType.equals(Type.NONE))
            currentType = command.getType();
        if (isAccumulative(command)) {
            strBuff = command.getStringValue();
            strCount++;
            currentMessage = command.messageDecorate(strCount);
            return true;
        } else {
            return false;
        }
    }

    public boolean accumulate(CharCommand command) {
        if (currentType.equals(Type.NONE))
            currentType = command.getType();
        if (!isAccumulative(command)) {
            strBuff = "";
            currentMessage = command.messageDecorate(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean accumulate(BooleanCommand command) {
        if (currentType.equals(Type.NONE))
            currentType = command.getType();
        if (!isAccumulative(command)) {
            strBuff = "";
            currentMessage = command.messageDecorate(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean accumulate(ObjectCommand command) {
        if (currentType.equals(Type.NONE))
            currentType = command.getType();
        if (!isAccumulative(command)) {
            strBuff = "";
            currentMessage = command.messageDecorate(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean isAccumulative(IntCommand command) {
        if (!command.getType().equals(currentType)) {
            return false;
        } else {
            return !command.isOverflow(this);
        }
    }

    public boolean isAccumulative(ByteCommand command) {
        if (!command.getType().equals(currentType)) {
            return false;
        } else {
            return !command.isOverflow(this);
        }
    }

    public boolean isAccumulative(StringCommand command) {
        if (!command.getType().equals(currentType)) {
            return false;
        } else {
            return (command.getStringValue().equals(strBuff) || (strBuff=="" && strCount==0));
        }
    }

    public boolean isAccumulative(CharCommand command) {
        if (!command.getType().equals(currentType)) {
            return false;
        } else {
            return !command.isOverflow(this);
        }
    }

    public boolean isAccumulative(BooleanCommand command) {
        if (!command.getType().equals(currentType)) {
            return false;
        } else {
            return !command.isOverflow(this);
        }
    }

    public boolean isAccumulative(ObjectCommand command) {
        if (!command.getType().equals(currentType)) {
            return false;
        } else {
            return !command.isOverflow(this);
        }
    }


    public int getIntBuff() {
        return intBuff;
    }

    public byte getByteBuff() {
        return byteBuff;
    }


    public void clean() {
        intBuff = 0;
        byteBuff = 0;
        strBuff = "";
        strCount = 0;

        currentType = Type.NONE;

        currentMessage = null;
    }

    public String getStrBuff() {
        return strBuff;
    }
}
