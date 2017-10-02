package ooaddemo;

import java.util.Date;

public class RSALoggerController extends LoggerController {
    private int rsaVerySpecificData = 0;

    {
        System.out.println("1");
        rsaVerySpecificData = 1;
    }

    {
        System.out.println("2");
    }

    public RSALoggerController(Accumulator currentAccumulator, int rsaVerySpecificData) {
        super(currentAccumulator);
        //block
        this.rsaVerySpecificData = rsaVerySpecificData;
    }

    public RSALoggerController() {
        super(null);
        Repository.register(this);
    }

    {
        System.out.println("3");
    }

    @Override
    protected Object encode(String message) {
        return "4";
    }
}

class RSAv2LoggerController extends RSALoggerController {
    @Override
    public Integer encode(String message) {
        return "v2" + super.encode(message);
    }
}