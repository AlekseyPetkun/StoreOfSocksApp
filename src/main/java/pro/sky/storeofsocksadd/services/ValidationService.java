package pro.sky.storeofsocksadd.services;


import pro.sky.storeofsocksadd.model.Socks;

/**
 * сервис валидации.
 */
public interface ValidationService {

    /**
     * Валидация сущности Socks
     * @param socks сущность для валидации.
     * @return валидность сущности
     */
    boolean validate(Socks socks);

}
