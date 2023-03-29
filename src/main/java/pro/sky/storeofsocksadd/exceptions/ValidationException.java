package pro.sky.storeofsocksadd.exceptions;

/**
 * Ошибка валидации.
 */
public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super("Ошибка валидации!");
    }
}
