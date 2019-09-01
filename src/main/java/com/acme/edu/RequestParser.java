package com.acme.edu;

public class RequestParser {
    public Request parse(String request){

        String[] splitted = request.split(",");
        String type = splitted[0];
        String value = splitted.length >= 2 ? splitted[1] : "";

        return new Request(type, value);
    }
}
