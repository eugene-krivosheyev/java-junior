package com.acme.edu;

/**
 * Factory conditions
 */
public class Factory {

    //region fields
    /**
     * switch States
     */
    LoggerState loggerState =  new StringState(new Printer());
    //endregion

    //region setter
    /**
     * Set the state: SUM_INTEGERS;
     * The sum of integers
     */
    public void setIntState() {
        this.loggerState = new IntState(new Printer());
    }

    /**
     * Set the state: STRING_REPEAITING;
     * Counting duplicate rows
     */
    public void setStringState() {
        this.loggerState = new StringState(new Printer());
    }

    /**
     * Set the state: SIMPLE_PRINT;
     * Easy printing
     */
    public void setSimplePrintState() {
        this.loggerState = new SimplePrintState(new Printer());
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
