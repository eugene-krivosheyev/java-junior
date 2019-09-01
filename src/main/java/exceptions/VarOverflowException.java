package exceptions;

public class VarOverflowException extends RuntimeException {
    public VarOverflowException(String errorMessage){
        super(errorMessage);
    }
}
