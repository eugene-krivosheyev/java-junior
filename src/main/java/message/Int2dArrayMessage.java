package message;

public class Int2dArrayMessage extends Message {

    private Integer[][] body;

    public Int2dArrayMessage(Integer[][] body) {
        this.body = body;
    }

    @Override
    public Integer[][] getBody() {
        return body;
    }
}
