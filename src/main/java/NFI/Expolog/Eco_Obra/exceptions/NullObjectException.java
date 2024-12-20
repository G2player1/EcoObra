package NFI.Expolog.Eco_Obra.exceptions;

public class NullObjectException extends RuntimeException {
    private final String message;

    public NullObjectException(String message) {
    this.message = message;
  }

    @Override
    public String getMessage() {
        return message;
    }
}
