package com.acme.edu;

public class Message {
    private Object message;
    private Prefics prefics;

    public Message(Object message, Prefics prefics) {
        this.message = message;
        this.prefics = prefics;
    }
    public Message(byte message, Prefics prefics){
        this.message = message;
        this.prefics = prefics;
    }
    public Message(char message, Prefics prefics){
        this.message = message;
        this.prefics = prefics;
    }
    public Message(int message, Prefics prefics){
        this.message = message;
        this.prefics = prefics;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Prefics getPrefics() {
        return prefics;
    }

    public void setPrefics(Prefics prefics) {
        this.prefics = prefics;
    }
    public String peficsShow(){
        String pref = "";
        switch (prefics){
            case PRIMITIVE:
                return pref="primitive: ";
            case CHAR:
                return pref="char: ";
            case STRNG:
                return pref="string: ";
            case REFRENCE:
                return pref="reference: ";
            case PRIMITIVES_ARR:
                return pref="primitives array: {";
            case PRIMITIVES_MTR:
                return pref="primitives matrix: {";
            case PRIMITIVES_MMTR:
                return pref = "primitives multimatrix: {";
        }
        return pref;
    }
}

enum Prefics{
    PRIMITIVE, CHAR, STRNG, REFRENCE, PRIMITIVES_ARR, PRIMITIVES_MTR, PRIMITIVES_MMTR
}
