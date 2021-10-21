package com.acme.edu.flush;

import com.acme.edu.dto.StatesDTO;
import com.acme.edu.saver.SystemOutSaver;

public class Flusher {

    private final SystemOutSaver saver;

    public Flusher() {
        this.saver = new SystemOutSaver();
    }

    public void flush(String message) {
        saver.save(message);
    }

    public void flush(StatesDTO statesDTO) {
        switch (statesDTO.getPrevTypeCodeEnum()) {
            case BOOLEAN: {
                saver.save(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getPrevBoolean());
                break;
            }
            case CHAR: {
                saver.save(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getPrevChar());
                break;
            }
            case STRING: {
                stringCase(statesDTO);
                break;
            }
            case BYTE: {
                saver.save(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getByteSum());
                statesDTO.clearByteSum();
                break;
            }
            case INTEGER: {
                saver.save(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getIntegerSum());
                statesDTO.clearIntegerSum();
                break;
            }
            case ARRAY_INT: {
                saver.save(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getArrayIntSum());
                statesDTO.clearArrayIntSum();
                break;
            }
            case MATRIX_INT: {
                saver.save(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getMatrixIntSum());
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
            saver.save(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getPrevString() + " (x" + statesDTO.getSimilarStringCounter() + ")");
        } else {
            saver.save(statesDTO.getPrevTypeCodeEnum().getTypeReference() + statesDTO.getPrevString());
        }
        statesDTO.setPrevString(null);
        statesDTO.clearSimilarStringCounter();
    }
}
