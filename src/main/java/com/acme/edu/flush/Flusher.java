package com.acme.edu.flush;

import com.acme.edu.Printer;
import com.acme.edu.StatesDTO;

import static com.acme.edu.typemapper.MessageTypeMapper.getPrefixType;

public class Flusher {
    public void flush(StatesDTO statesDTO) {
        switch (statesDTO.getPrevTypeCodeEnum()) {
            case STRING: {
                statesDTO.incSimilarStringCounter();
                if (statesDTO.getSimilarStringCounter() > 1) {
                    Printer.print(getPrefixType(statesDTO.getPrevTypeCodeEnum()) + statesDTO.getPrevString() + " (x" + statesDTO.getSimilarStringCounter() + ")");
                } else {
                    Printer.print(getPrefixType(statesDTO.getPrevTypeCodeEnum()) + statesDTO.getPrevString());
                }
                statesDTO.setPrevString(null);
                statesDTO.clearSimilarStringCounter();
                break;
            }
            case BYTE: {
                Printer.print(getPrefixType(statesDTO.getPrevTypeCodeEnum()) + statesDTO.getByteSum());
                statesDTO.clearByteSum();
                break;
            }
            case INTEGER: {
                Printer.print(getPrefixType(statesDTO.getPrevTypeCodeEnum()) + statesDTO.getIntegerSum());
                statesDTO.clearIntegerSum();
                break;
            }
            case ARRAY_INT: {
                Printer.print(getPrefixType(statesDTO.getPrevTypeCodeEnum()) + statesDTO.getArrayIntSum());
                statesDTO.clearArrayIntSum();
                break;
            }
            case MATRIX_INT: {
                Printer.print(getPrefixType(statesDTO.getPrevTypeCodeEnum()) + statesDTO.getMatrixIntSum());
                statesDTO.clearMatrixIntSum();
                break;
            }
            default:
                break;
        }
    }
}
