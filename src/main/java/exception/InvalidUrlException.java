package exception;

public class InvalidUrlException extends RuntimeException {

    public InvalidUrlException(String url) {
        super(String.format("URL => %s <= is invalid", url));
    }
}
