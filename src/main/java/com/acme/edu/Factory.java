package com.acme.edu;

/**
 * Factory conditions
 */
public class Factory {

    //region fields

    private IntState intState;
    private StringState stringState;
    private SimplePrintState simplePrintState;
    /**
     * switch States
     */
    public LoggerState loggerState;
    //endregion


    //region constructor
    public Factory(IntState intState, StringState stringState, SimplePrintState simplePrintState) {
        this.intState = intState;
        this.stringState = stringState;
        this.simplePrintState = simplePrintState;
    }
    //endregion

    //region setter
    /**
     * Set the state: SUM_INTEGERS;
     * The sum of integers
     */
    public void setIntState() {
        this.loggerState = intState;
    }

    /**
     * Set the state: STRING_REPEAITING;
     * Counting duplicate rows
     */
    public void setStringState() {
        this.loggerState = stringState;
    }

    /**
     * Set the state: SIMPLE_PRINT;
     * Easy printing
     */
    public void setSimplePrintState() {
        this.loggerState = simplePrintState;
    }
    //endregion

    //region getter
    /**
     * Returns one of the States
     * @return state
     */
    public LoggerStateHolder getState(){
        if (loggerState instanceof IntState){
            return LoggerStateHolder.SUM_INTEGERS;
        }else if (loggerState instanceof StringState){
            return LoggerStateHolder.STRING_REPEAITING;
        }else{
            return LoggerStateHolder.SIMPLE_PRINT;
        }
    }
    //endregion
}
