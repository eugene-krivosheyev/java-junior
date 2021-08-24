package demo;

public class InstatiationDemo {
    public static void main(String[] args) {

    }
}

class BaseRequest {
    private int severity;

    public BaseRequest(int severity) {
        this.severity = severity;
    }
}

class Request extends BaseRequest {
    private String message;

    {
        System.out.println("!!!!");
    }

    Request(String message, int severity) {
        super(severity);
        this.message = message;
        //2 line : {}
    }

    public Request() {
        this("", 1);
//        super(1);
    }
}