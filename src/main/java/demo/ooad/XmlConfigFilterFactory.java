package demo.ooad;

public class XmlConfigFilterFactory {
    public static LoggerFilter create() {
        return new ContentLengthLoggerFilter(0);
    }
}
