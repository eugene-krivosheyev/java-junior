package com.db.ooad;

enum MsgSeverity {
    INFO, DEBUG, ERROR
}

public class ContentSeverityFilter implements LoggerFilter {

    private MsgSeverity msgSeverity;

    ContentSeverityFilter(MsgSeverity msgSeverity){
        this.msgSeverity = msgSeverity;
    }

    @Override
    public boolean filter(String message) {
        MsgSeverity curSeverity;
        String strLvl = message.substring(message.indexOf('[') + 1, message.indexOf(']'));
        curSeverity = MsgSeverity.valueOf(strLvl);

        return (curSeverity.ordinal() >= msgSeverity.ordinal() ? true : false);
    }
}
