package ooaddemo;

import java.util.Date;

@SuppressWarnings({"unchecked"})
public class RSALoggerController extends LoggerController {
    @Autowired
    @Named
    private SaverFactory saverFactory;

    public RSALoggerController(Accumulator byteAccumulator, Accumulator stringAccumulator) {
        super(byteAccumulator, stringAccumulator);
    }

    @Override
    @Deprecated
    protected Object encode(String message) {
        new Date(10,10,2010);
        return "4";
    }
}

class RSAv2LoggerController extends RSALoggerController {
    public RSAv2LoggerController(Accumulator byteAccumulator, Accumulator stringAccumulator) {
        super(byteAccumulator, stringAccumulator);
    }

    @Override
    public Integer encode(String message) {
        return 4;//"v2" + super.encode(message);
    }
}