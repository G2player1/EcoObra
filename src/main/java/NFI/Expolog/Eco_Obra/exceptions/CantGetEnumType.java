package NFI.Expolog.Eco_Obra.exceptions;

public class CantGetEnumType extends RuntimeException {
    private final String message;

    public CantGetEnumType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
