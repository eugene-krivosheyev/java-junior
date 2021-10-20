package com.acme.edu.typemapper;

import com.acme.edu.TypeCodeEnum;

import static com.acme.edu.TypeCodeEnum.*;

public final class MessageTypeMapper {

    public static TypeCodeEnum getType(Object message) {
        if (message.getClass() == String.class) {
            return STRING;
        }
        if (message.getClass() == Byte.class) {
            return BYTE;
        }
        if (message.getClass() == Integer.class) {
            return INTEGER;
        }
        if (message.getClass() == Object.class) {
            return OBJECT;
        }
        if (message.getClass() == Boolean.class) {
            return BOOLEAN;
        }
        if (message.getClass() == Character.class) {
            return CHAR;
        }
        if (message.getClass() == int[].class) {
            return ARRAY_INT;
        }
        if (message.getClass() == int[][].class) {
            return MATRIX_INT;
        }
        return NONE;
    }

    public static String getPrefixType(TypeCodeEnum typeCodeEnum) {
        switch (typeCodeEnum) {
            case STRING: {
                return STRING.getTypeReference();
            }
            case OBJECT: {
                return OBJECT.getTypeReference();
            }
            case CHAR: {
                return CHAR.getTypeReference();
            }
            case BYTE:
            case BOOLEAN:
            case INTEGER: {
                return BYTE.getTypeReference();
            }
            case MATRIX_INT: {
                return MATRIX_INT.getTypeReference();
            }
            case ARRAY_INT: {
                return ARRAY_INT.getTypeReference();
            }
            default:
                return null;
        }
    }
}
