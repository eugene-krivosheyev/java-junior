package message;

public class IntMessage extends Message
{
    private Integer body;

    public IntMessage(Integer integer) {
        body = integer;
    }

    @Override
    public Integer getBody() {
        return body;
    }
}
