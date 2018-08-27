package newlogger.message;

class FlushMessage implements Message {
    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
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
