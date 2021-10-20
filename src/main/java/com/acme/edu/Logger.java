package com.acme.edu;

import com.acme.edu.flush.Flusher;

import java.util.Objects;

import static com.acme.edu.typemapper.MessageTypeMapper.getPrefixType;
import static com.acme.edu.typemapper.MessageTypeMapper.getType;
import static com.acme.edu.TypeCodeEnum.*;

public class Logger {
    private static StatesDTO statesDTO;
    private static Flusher flusher;

    public Logger() {
        statesDTO = new StatesDTO();
        flusher = new Flusher();
    }

    public static void log(Object message) {
        TypeCodeEnum TypeCodeEnum = getType(message);

        if (statesDTO.getPrevTypeCodeEnum() != NONE && TypeCodeEnum != statesDTO.getPrevTypeCodeEnum()) {
            flusher.flush(statesDTO);
        }

        switch (TypeCodeEnum) {
            case STRING: {
                if (Objects.equals(statesDTO.getPrevString(), message)) {
                    statesDTO.incSimilarStringCounter();
                } else if (statesDTO.getPrevString() != null) {
                    flusher.flush(statesDTO);
                }
                statesDTO.setPrevString((String) message);
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
                for (int i: (int[]) message) {
                    statesDTO.setArrayIntSum(i);
                }
                break;
            }
            case MATRIX_INT: {
                for (int[] i: (int[][])message) {
                    for (int j: i)
                        statesDTO.setMatrixIntSum(j);
                }
                break;
            }
            default: {
                Printer.print(getPrefixType(TypeCodeEnum) + message);
            }
        }
        statesDTO.setPrevTypeCodeEnum(TypeCodeEnum);
    }
}
