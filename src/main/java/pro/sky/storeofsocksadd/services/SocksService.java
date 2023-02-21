package pro.sky.storeofsocksadd.services;


import pro.sky.storeofsocksadd.model.Socks;
import pro.sky.storeofsocksadd.model.enums.Color;
import pro.sky.storeofsocksadd.model.enums.Size;

import java.util.Collection;

/**
 * Сервис по работе с носками.
 */
public interface SocksService {

    /**
     * Создаем сущность носки
     * @param color цвет носков
     * @param size размер носков
     * @param cottonPart содержание хлопка в носках
     * @param quantity количество пар
     * @return сущность носки
     */
    Socks add(Color color, Size size, int cottonPart, int quantity);

    /**
     * Сохраняем сущность носки
     * @param socks сущность носки
     * @return сохраненную сущность носки
     */
    Socks save(Socks socks);

    /**
     * Редактируем количество носков
     * @param color цвет носков
     * @param size размер носков
     * @param cottonPart содержание хлопка в носках
     * @param quantity количество пар, которое нужно изъять со склада
     * @return измененную сущность носки
     */
    Socks editCount(Color color, Size size, int cottonPart, int quantity);

    /**
     * Получаем количество всех сущностей, согласно параметрам.
     * @return список количество всех сущностей.
     */

    String getAllByParameters(Color color, Size size, int cottonMin, int cottonMax);
}
