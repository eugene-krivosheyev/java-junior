package com.acme.edu;

import com.acme.edu.dto.StatesDTO;
import com.acme.edu.flush.Flusher;

import java.util.Objects;

import static com.acme.edu.TypeCodeEnum.NONE;
import static com.acme.edu.typemapper.MessageTypeMapper.getType;

public class Logger {
    private final StatesDTO statesDTO;
    private final Flusher flusher;

    public Logger(StatesDTO statesDTO) {
        this.statesDTO = statesDTO;
        this.flusher = new Flusher();
    }

    public void log(Object message) {
        TypeCodeEnum typeCodeEnum = getType(message);

        if (statesDTO.getPrevTypeCodeEnum() != NONE && typeCodeEnum != statesDTO.getPrevTypeCodeEnum()) {
            flusher.flush(statesDTO);
        }

        switch (typeCodeEnum) {
            case STRING: {
                stringIteration((String) message);
                break;
            }
            case BYTE: {
                statesDTO.setByteSum((byte) message);
                break;
            }
            case INTEGER: {
                statesDTO.setIntegerSum((int) message);
                break;
            }
            case ARRAY_INT: {
                arrayIncrementor((int[]) message);
                break;
            }
            case MATRIX_INT: {
                for (int[] row : (int[][]) message) {
                    arrayIncrementor(row);
                }
                break;
            }
            default: {
                flusher.flush(typeCodeEnum.getTypeReference() + message);
            }
        }
        statesDTO.setPrevTypeCodeEnum(typeCodeEnum);
    }

    private void arrayIncrementor(int[] message) {
        for (int i : message) {
            statesDTO.setArrayIntSum(i);
        }
    }

    private void stringIteration(String message) {
        if (Objects.equals(statesDTO.getPrevString(), message)) {
            statesDTO.incSimilarStringCounter();
        } else if (statesDTO.getPrevString() != null) {
            flusher.flush(statesDTO);
        }
        statesDTO.setPrevString(message);
    }
}
