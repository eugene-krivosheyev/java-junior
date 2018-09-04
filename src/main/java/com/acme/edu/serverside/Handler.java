package com.acme.edu.serverside;

import com.acme.edu.Logger;

public class Handler {
    public static void parse(String stringToParse) {
        int endIndex = stringToParse.indexOf('>');
        String type = stringToParse.substring(1, endIndex);
        String data = stringToParse.substring(endIndex+1);
        switch (type) {
            case "int":
                Logger.log(Integer.parseInt(data));
                break;
            case "byte":
                Logger.log(Byte.parseByte(data));
                break;
            case "boolean":
                Logger.log(Boolean.parseBoolean(data));
                break;
            case "char":
                Logger.log(data.charAt(0));
                break;
            case "string":
                Logger.log(data);
                break;
            case "flush":
                Logger.flush();
                break;
        }
    }
}
