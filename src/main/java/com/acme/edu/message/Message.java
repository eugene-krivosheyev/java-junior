package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class Message {
    TypeCodeEnum typeCodeEnum;

    public Message() {
        typeCodeEnum = TypeCodeEnum.NONE;
    }

    public TypeCodeEnum getCode() {
        return typeCodeEnum;
    }
}
