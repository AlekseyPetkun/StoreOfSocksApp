package pro.sky.storeofsocksadd.model;

import lombok.*;
import pro.sky.storeofsocksadd.model.enums.Color;
import pro.sky.storeofsocksadd.model.enums.Size;

/**
 * Сущность - носки.
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Socks {

    private Color color;
    private Size size;
    private int cottonPart;

    private int quantity;

    @Override
    public String toString() {
        return "Носки: \n" +
                "цвет - " + color + "\n" +
                ", размер - " + size + "\n" +
                ", состав - " + cottonPart + "% хлопка\n"+
                ", количество на складе - " + quantity + " шт.\n";
    }
}
