package NFI.Expolog.Eco_Obra.exceptions;

public class CantRegisterBuyException extends RuntimeException{
    private final String message;

    public CantRegisterBuyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
