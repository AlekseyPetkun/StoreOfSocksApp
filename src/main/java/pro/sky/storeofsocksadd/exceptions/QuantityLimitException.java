package pro.sky.storeofsocksadd.exceptions;

/**
 * Ошибка количества доступных пар носков на складе.
 */
public class QuantityLimitException extends RuntimeException{

    public QuantityLimitException(String message) {
        super("Заданное количество пар носков превысило количество пар на складе!");
    }
}
