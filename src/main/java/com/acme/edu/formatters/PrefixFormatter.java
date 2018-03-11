package com.acme.edu.formatters;

import com.acme.edu.message.*;

import static java.lang.System.lineSeparator;

public class PrefixFormatter {

    public PrefixFormatter() {
    }

    public String visitIntMessage(IntMessage message) {
        return "primitive: ";
    }
    public String visitByteMessage(ByteMessage message) {
        return "primitive: ";
    }
    public String visitCharMessage(CharMessage message) {
        return "char: ";
    }
    public String visitBooleanMessage(BooleanMessage message) {
        return "primitive: ";
    }
    public String visitStringMessage(StringMessage message) {
        return "string: ";
    }
    public String visitObjectMessage(ObjectMessage message) {
        return "reference: ";
    }
    public String visitIntArrayMessage(IntArrayMessage message){
        return "primitives array: {";
    }
    public String visitIntDblArrayMessage(IntDdlArrayMessage message){
        return "primitives matrix: {"+lineSeparator();
    }
    public String visitIntQtrArrayMessage(IntQtrArrayMessage message){
        return "primitives multimatrix: {"+lineSeparator();
    }
    public String visitStringArrayMessage(StringArrayMessage message){
        return "string array: "+lineSeparator();
    }
}
