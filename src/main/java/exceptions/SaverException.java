package exceptions;

public class SaverException extends RuntimeException {
    public SaverException(Exception e){
        super(e);
    }
}
