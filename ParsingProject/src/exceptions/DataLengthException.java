package exceptions;

public class DataLengthException extends RuntimeException{
    private int length;
    private String format;
    public DataLengthException(int length, String format){
        this.length = length;
    }

    @Override
    public String getMessage() {
        return "Количество данных "+length+" не соответствует формату "+ format;
    }
}
