package demo.ooad.filter;

public class XmlConfigFilterFactory {
    public LoggerFilter create() {
        return new ContentLengthLoggerFilter(0);
    }
}
