package newlogger.message;

class StringMessage implements Message {
    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(final Message message) {
        return message instanceof StringMessage;
        //10 ksloc
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
