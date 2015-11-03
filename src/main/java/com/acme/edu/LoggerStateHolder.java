package com.acme.edu;

/**
 * Created by Павел on 03.11.2015.
 */
//отрефакторить в фабрику!!!!
public enum LoggerStateHolder {

    STRING_REPEAITING(new StringState(null)), //Подсчет повторяющихся строк
    SUM_INTEGERS(new IntState(null)),         //Суммирование целых чисел
    SIMPLE_PRINT(new SimplePrintState(null)); //Простой вывод чисел

    LoggerState loggerState = null;


    LoggerStateHolder(SimplePrintState simplePrintState) {
        this.loggerState = simplePrintState;
    }

    LoggerStateHolder(IntState intState) {
        this.loggerState = intState;
    }

    LoggerStateHolder(StringState stringState) {
        this.loggerState = stringState;
    }

    LoggerState getLoggerState() {
        return loggerState;
    }
}
