package exceptions;

public class MenuException extends RuntimeException{
    private String message;
    public MenuException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
