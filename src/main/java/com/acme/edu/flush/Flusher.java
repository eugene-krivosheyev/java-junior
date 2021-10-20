package com.acme.edu.flush;

import com.acme.edu.dto.StatesDTO;

public class Flusher {

    public void flush(String message) {
        Printer.print(message);
    }

    public void flush(StatesDTO statesDTO) {
        switch (statesDTO.getPrevTypeCodeEnum()) {
            case STRING: {
                stringCase(statesDTO);
                break;
            }
            case BYTE: {
                Printer.print(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getByteSum());
                statesDTO.clearByteSum();
                break;
            }
            case INTEGER: {
                Printer.print(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getIntegerSum());
                statesDTO.clearIntegerSum();
                break;
            }
            case ARRAY_INT: {
                Printer.print(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getArrayIntSum());
                statesDTO.clearArrayIntSum();
                break;
            }
            case MATRIX_INT: {
                Printer.print(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getMatrixIntSum());
                statesDTO.clearMatrixIntSum();
                break;
            }
            default:
                break;
        }
    }

    private void stringCase(StatesDTO statesDTO) {
        statesDTO.incSimilarStringCounter();
        if (statesDTO.getSimilarStringCounter() > 1) {
            Printer.print(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getPrevString() + " (x" + statesDTO.getSimilarStringCounter() + ")");
        } else {
            Printer.print(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getPrevString());
        }
        statesDTO.setPrevString(null);
        statesDTO.clearSimilarStringCounter();
    }
}
