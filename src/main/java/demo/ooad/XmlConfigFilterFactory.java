package demo.ooad;

public class XmlConfigFilterFactory {
    public LoggerFilter create() {
        return new ContentLengthLoggerFilter(0);
    }
}
