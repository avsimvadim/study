package JPA_hibernate.EShop.exceptions;

public class NoUserFoundException extends Exception {
    public NoUserFoundException() {
    }

    public NoUserFoundException(String message) {
        super(message);
    }
}
