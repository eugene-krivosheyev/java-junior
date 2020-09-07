package com.acme.edu;

import com.acme.edu.message.IntCommand;
import com.acme.edu.message.LogMessage;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    LoggerSaver saver = new ConsoleSaver();

//    private void flushBuffer(LogMessage message, boolean flushInt, boolean flushStr, boolean flushByte) {
//        if (IntCommand.intFlag) {
//            saver.save(message.getDecoratedSelf());
//            IntCommand.reset();
//        }
//        if (flushByte) {
//            directToOutput(PREFIX_PRIMITIVE + byteBuffer);
//            byteFlag = false;
//            byteBuffer = 0;
//        }
//        if (flushStr) {
//            if (counterSameStr > 1)
//                directToOutput(PREFIX_STRING + strBuffer + " (x" + counterSameStr + ")");
//            if (counterSameStr == 1)
//                directToOutput(PREFIX_STRING + strBuffer);
//            strFlag = false;
//            strBuffer = "";
//            counterSameStr = 0;
//        }
//    }

    public void log (LogMessage message){
        if (message.checkFlush()){
            flushBuffer(intCommand.intFlag, strCommand.strFlag, byteCommand.byteFlag)
            saver.save(message.getDecoratedSelf());
        }

    }
}
