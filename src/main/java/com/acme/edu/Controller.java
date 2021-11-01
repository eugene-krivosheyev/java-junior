package com.acme.edu;

import com.acme.edu.message.*;

import java.util.Objects;

import static com.acme.edu.TypeCodeEnum.NONE;

public class Controller {
    private final StatesDTO statesDTO;
    private final Flusher flusher;

    public Controller(StatesDTO statesDTO) {
        this.statesDTO = statesDTO;
        this.flusher = new Flusher();
    }

    public Controller(StatesDTO statesDTO, Flusher flusher) {
        this.statesDTO = statesDTO;
        this.flusher = flusher;
    }

    public void log(Message message) {
        TypeCodeEnum typeCodeEnum = message.getCode();

        if (statesDTO.getPrevTypeCodeEnum() != NONE && typeCodeEnum != statesDTO.getPrevTypeCodeEnum()) {
            flusher.flush(statesDTO);
        }

        switch (typeCodeEnum) {
            case BOOLEAN: {
                statesDTO.setPrevBoolean((BooleanMessage) message);
                break;
            }
            case CHAR: {
                statesDTO.setPrevChar((CharMessage) message);
                break;
            }
            case STRING: {
                stringIteration((StringMessage) message);
                break;
            }
            case BYTE: {
                statesDTO.setByteSum((ByteMessage) message);
                break;
            }
            case INTEGER: {
                statesDTO.setIntegerSum((IntMessage) message);
                break;
            }
            case ARRAY_INT: {
                statesDTO.arrayIncrementer((ArrayMessage) message);
                break;
            }
            case MATRIX_INT: {
                statesDTO.matrixIncrementer((MatrixMessage) message);
                break;
            }
            default: {
                flusher.flush(typeCodeEnum.getTypeReference() + message);
            }
        }
        statesDTO.setPrevTypeCodeEnum(typeCodeEnum);
    }

    private void stringIteration(StringMessage message) {
        if (Objects.equals(statesDTO.getPrevString(), message.getMessage())) {
            statesDTO.incSimilarStringCounter();
        } else if (statesDTO.getPrevString() != null) {
            flusher.flush(statesDTO);
        }
        statesDTO.setPrevString(message.getMessage());
    }
}
