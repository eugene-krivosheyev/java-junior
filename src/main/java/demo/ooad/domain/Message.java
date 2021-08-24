package demo.ooad.domain;

/**
 * Stateful
 * Immutable
 * POJO ≠ JavaBeans
 */
public class Message {
    private final String body; //state
    private final SeverityLevel severity;

    /**
     * Public API
     */
    public Message(String body, SeverityLevel severity) {
        this.body = body;
        this.severity = severity;
    }

    /**
     * Up-front design
     * @return
     */
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "{ " + body  + " }";
    }
}
