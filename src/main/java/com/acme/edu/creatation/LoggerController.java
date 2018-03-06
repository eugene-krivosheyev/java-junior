package com.acme.edu.creatation;

//@Component
//@Scope
public class LoggerController {
//    @Inject
    private Saver saver; //Field DI

    /**
     * Constructor DI
     */
//    @Autowired
    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    /**
     * Setter DI
     */
    public void setSaver(Saver saver) {
        this.saver = saver;
    }

    public void log() {
        saver.save();
    }
}
