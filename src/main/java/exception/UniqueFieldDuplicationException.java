package exception;

public class UniqueFieldDuplicationException extends RuntimeException {
    public UniqueFieldDuplicationException(String message) {
        super(message);
    }
}
