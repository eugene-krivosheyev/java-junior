package newlogger.message;

class IntMessage implements Message {
    private int message;

    public IntMessage(int message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }
}
