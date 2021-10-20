package com.acme.edu;

import com.acme.edu.flush.Flusher;

import java.util.Objects;

import static com.acme.edu.TypeCodeEnum.NONE;
import static com.acme.edu.typemapper.MessageTypeMapper.getPrefixType;
import static com.acme.edu.typemapper.MessageTypeMapper.getType;

public class Logger {
    private StatesDTO statesDTO;
    private Flusher flusher;

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
                for (int i : (int[]) message) {
                    statesDTO.setArrayIntSum(i);
                }
                break;
            }
            case MATRIX_INT: {
                for (int[] i : (int[][]) message) {
                    for (int j : i)
                        statesDTO.setMatrixIntSum(j);
                }
                break;
            }
            default: {
                Printer.print(getPrefixType(typeCodeEnum) + message);
            }
        }
        statesDTO.setPrevTypeCodeEnum(typeCodeEnum);
    }
}
