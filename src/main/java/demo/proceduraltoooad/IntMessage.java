package demo.proceduraltoooad;

import java.util.Date;

class AbstractMessage extends Object {
    private String timestamp;

    public AbstractMessage(String timestamp) {
        this.timestamp = timestamp;
    }
}

public class IntMessage extends AbstractMessage {
    private int message;

    public IntMessage(String timestamp) {
        super(timestamp);
    }

    public IntMessage(int message) {
        this();
        // {}
        this.message = message;
    }

    public IntMessage() {
        super(new Date().toString());
        // {}
        System.out.println("");
    }

    {
        System.out.println();
    }

    public String getDecoratedMessage() {
        return "PRIMITIVE: " + this.message;
    }
}
