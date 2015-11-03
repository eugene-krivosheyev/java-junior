package com.acme.edu;

/**
 * Created by Павел on 03.11.2015.
 */
public enum LoggerStateHolder {

    STRING_REPEAITING(new StringState()), //Подсчет повторяющихся строк
    SUM_INTEGERS(new IntState()),         //Суммирование целых чисел
    SIMPLE_PRINT(new SimplePrintState()); //Простой вывод

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
