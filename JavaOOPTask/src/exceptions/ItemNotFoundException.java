package exceptions;

public class ItemNotFoundException extends BaseException {


    private String description;

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
