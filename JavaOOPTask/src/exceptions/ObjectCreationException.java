package exceptions;

public class ObjectCreationException extends BaseException {


    private String description;

    public ObjectCreationException(String message) {
        super(message);
    }

    public ObjectCreationException(String message, String description) {
        super(message);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
